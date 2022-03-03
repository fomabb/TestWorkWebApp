package com.example.testing.dao;

import com.example.testing.dto.UserUpdate;
import com.example.testing.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUser();

    User getById(long id);

    void userAdd(User user);

    void userDelete(long id);

    void updateUser(long id, UserUpdate user);
}
