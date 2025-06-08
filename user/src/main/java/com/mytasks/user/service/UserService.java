package com.mytasks.user.service;

import com.mytasks.user.dto.UserRequest;
import com.mytasks.user.exception.UserAlreadyExistsException;
import com.mytasks.user.model.User;
import com.mytasks.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> create(UserRequest userRequest) throws Exception {
       Optional<User> existUser = userRepository.findByEmail(userRequest.getEmail());
        
    if (existUser.isPresent() && existUser.get().getEmail().equals(userRequest.getEmail())){
        throw new UserAlreadyExistsException("User with email " + userRequest.getEmail() + " already exists.");
    }

        User user = new User();
        user.setNome(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        return Optional.of(userRepository.save(user));
    }

    public Optional<User> update(Long id, UserRequest userRequest) {
        Optional<User> existUser = userRepository.findByEmail(userRequest.getEmail());

        if (existUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userRequest.getEmail() + " already exists.");
        }
        
        User user = new User();
        user.setNome(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        
        return Optional.of(userRepository.save(user));
    }

    public boolean delete(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
