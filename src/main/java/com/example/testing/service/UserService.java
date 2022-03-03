package com.example.testing.service;

import com.example.testing.dto.UserDataDTO;
import com.example.testing.dto.UserRegistrationDTO;

import java.util.List;

public interface UserService {

    List<UserDataDTO> getAllUser();

    UserDataDTO getById(long id);

    void userRegistration(UserRegistrationDTO userRegistrationDTO);
}
