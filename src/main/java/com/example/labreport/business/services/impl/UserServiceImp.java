package com.example.labreport.business.services.impl;

import com.example.labreport.model.User;

import java.util.List;

public interface UserServiceImp {

    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);

}
