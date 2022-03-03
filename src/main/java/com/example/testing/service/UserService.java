package com.example.testing.service;

import com.example.testing.dto.UserDataDTO;
import com.example.testing.dto.UserRegistrationDTO;
import com.example.testing.dto.UserUpdate;

import java.util.List;

public interface UserService {

    List<UserDataDTO> getAllUser();

    UserDataDTO getById(long id);

    void userRegistration(UserRegistrationDTO userRegistrationDTO);

    String userDelete(long id);

    void updateUser(long id, UserUpdate user);
}
