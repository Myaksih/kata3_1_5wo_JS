package com.example.kata3_1_5wo_js.service;


import com.example.kata3_1_5wo_js.model.User;
import com.example.kata3_1_5wo_js.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        if (!(user.getPassword().equals(userRepository.getById(user.getId()).getPassword()))) {
            user.setPassword(user.getPassword());
        }
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
