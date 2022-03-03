package com.example.testing.service.impl;

import com.example.testing.dao.UserDAO;
import com.example.testing.dto.UserDataDTO;
import com.example.testing.dto.UserRegistrationDTO;
import com.example.testing.model.User;
import com.example.testing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<UserDataDTO> getAllUser() {
        return userDAO.getAllUser().stream()
                .map(user -> new UserDataDTO(user.getUser_id(), user.getLogin(), user.getPassword(), user.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public void userRegistration(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();
        user.setLogin(userRegistrationDTO.getLogin());
        user.setPassword(DigestUtils.md5Hex(userRegistrationDTO.getPassword()));
        user.setEmail(userRegistrationDTO.getEmail());
        userDAO.userAdd(user);
    }
}