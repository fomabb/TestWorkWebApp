package com.example.testing.dao;

import com.example.testing.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUser();

    void userAdd(User user);
}
