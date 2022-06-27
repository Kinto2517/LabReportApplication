package com.example.labreport.business.services;

import com.example.labreport.business.services.impl.UserServiceImp;
import com.example.labreport.dao.UserRepository;
import com.example.labreport.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId()).get();

        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());
        userToUpdate.setName(user.getName());
        userToUpdate.setSurname(user.getSurname());

        userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
