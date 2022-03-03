package com.example.testing.dao.impl;

import com.example.testing.dao.UserDAO;
import com.example.testing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_USER_SQL = "SELECT * FROM user";

    private static final String ADD_USER_SQL = "INSERT INTO user VALUES(0,?,?,?)";

    @Override
    public List<User> getAllUser() {
        return jdbcTemplate.query(GET_ALL_USER_SQL, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void userAdd(User user) {
        jdbcTemplate.update(ADD_USER_SQL, user.getLogin(), user.getPassword(), user.getEmail());
    }
}