package com.example.simplilearnSorinScintei.Services;

import com.example.simplilearnSorinScintei.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceDaoImplementation implements UserServiceDao{
    private final UserService userService;


    @Override
    public User findByUsername(String username) {
        return userService.getUserByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return org.springframework.security.core.userdetails.User
                .builder().username(user.getFullName()).password(user.getPassword()).roles(getRoles(user)).build();
    }

    public String[] getRoles(User user) {
        if(user.getRole()==null) {
            return new String[] {"CUSTOMER"};
        }else {
            return user.getRole().split(",");
        }
    }
}
