package com.example.testing.mapper;

import com.example.testing.model.User;
import com.example.testing.util.constant.UserConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getLong(UserConstant.ID));
        user.setLogin(rs.getString(UserConstant.LOGIN));
        user.setPassword(rs.getString(UserConstant.PASSWORD));
        user.setEmail(rs.getString(UserConstant.EMAIL));
        return user;
    }
}
