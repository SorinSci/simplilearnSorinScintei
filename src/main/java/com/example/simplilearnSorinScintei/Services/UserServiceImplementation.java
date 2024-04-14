package com.example.simplilearnSorinScintei.Services;

import com.example.simplilearnSorinScintei.Models.User;
import com.example.simplilearnSorinScintei.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{

    private final UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id)  {
            Optional<User> user = userRepository.findById(id);
            return user.get();
    }

    @Override
    public List<User> addUser(User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }


    @Override
    public List<User> deleteUser(int id){
            Optional<User> user = userRepository.findById(id);
            user.ifPresent(value -> userRepository.delete(value));
            return userRepository.findAll();

    }
    @Override
    public User getUserByUserName(String username) {

        return userRepository.getByUsername(username);
    }
}
