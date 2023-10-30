package com.example.kata3_1_5wo_js.security;

import com.example.kata3_1_5wo_js.model.Role;
import com.example.kata3_1_5wo_js.model.User;
import com.example.kata3_1_5wo_js.service.UserServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class Security implements UserDetailsService {

    private final UserServiceImpl userServiceImp;
    public Security(UserServiceImpl userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userServiceImp.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User `%s` not found", name));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthority(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthority(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }

}
