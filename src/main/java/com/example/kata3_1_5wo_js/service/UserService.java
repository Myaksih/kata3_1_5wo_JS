package com.example.kata3_1_5wo_js.service;




import com.example.kata3_1_5wo_js.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void save(User user);

    void update(User user);

    void deleteUser(Long id);
    User findByUsername(String username);

}
