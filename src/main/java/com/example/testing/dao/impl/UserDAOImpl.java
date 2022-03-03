package com.example.testing.dao.impl;

import com.example.testing.dao.UserDAO;
import com.example.testing.dto.UserUpdate;
import com.example.testing.mapper.UserRowMapper;
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
    private static final String GET_BY_ID_SQL = "SELECT * FROM user WHERE user_id=?";
    private static final String DELETE_USER_SQL = "DELETE FROM user WHERE user_id=?";
    private static final String UPDATE_USER_SQL = "UPDATE user SET login=? WHERE user_id=?";

    @Override
    public List<User> getAllUser() {
        return jdbcTemplate.query(GET_ALL_USER_SQL, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User getById(long id) {
        return jdbcTemplate.query(GET_BY_ID_SQL, new Object[]{id}, new UserRowMapper()).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void userAdd(User user) {
        jdbcTemplate.update(ADD_USER_SQL, user.getLogin(), user.getPassword(), user.getEmail());
    }

    @Override
    public void userDelete(long id) {
        System.out.println(id);
        jdbcTemplate.update(DELETE_USER_SQL, id);
    }

    @Override
    public void updateUser(long id, UserUpdate user) {
        jdbcTemplate.update(UPDATE_USER_SQL, user.getLogin(), id);
    }
}
