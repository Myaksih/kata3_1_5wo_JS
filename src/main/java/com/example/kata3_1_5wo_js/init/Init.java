package com.example.kata3_1_5wo_js.init;

import com.example.kata3_1_5wo_js.model.User;
import com.example.kata3_1_5wo_js.repository.RoleRepository;
import com.example.kata3_1_5wo_js.service.UserService;
import org.springframework.stereotype.Component;
import com.example.kata3_1_5wo_js.model.Role;
import javax.annotation.PostConstruct;
import java.util.Collections;
@Component
public class Init {


    private UserService userService;

    private RoleRepository roleRepository;

    public Init(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {
        Role role = new Role("ROLE_USER");
        roleRepository.save(role);

        Role role1 = new Role("ROLE_ADMIN");
        roleRepository.save(role1);

        User user = new User();
        user.setFirstName("symon");
        user.setLastName("Kozhemyakin");
        user.setUsername("symon@gmail.com");
        user.setPassword("100");
        user.setRoles(Collections.singletonList(role));
        userService.save(user);

        User user1 = new User();
        user1.setFirstName("kolya");
        user1.setLastName("Kozhemyakin");
        user1.setUsername("kolya@gmail.com");
        user1.setPassword("100");
        user1.setRoles(Collections.singletonList(role1));
        userService.save(user1);
    }
}
