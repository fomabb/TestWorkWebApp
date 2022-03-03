package com.example.testing.service;

import com.example.testing.dto.UserDataDTO;
import com.example.testing.dto.UserRegistrationDTO;

import java.util.List;

public interface UserService {

    List<UserDataDTO> getAllUser();

    void userRegistration(UserRegistrationDTO userRegistrationDTO);
}
