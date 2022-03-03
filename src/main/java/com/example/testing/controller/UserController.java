package com.example.testing.controller;

import com.example.testing.dto.UserDataDTO;
import com.example.testing.dto.UserRegistrationDTO;
import com.example.testing.dto.UserUpdate;
import com.example.testing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/hello")
    public String read() {
        return "Hello";
    }

    @GetMapping
    public List<UserDataDTO> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    UserDataDTO getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    void userRegistration(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        userService.userRegistration(userRegistrationDTO);
    }

    @DeleteMapping("/{id}")
    String userDelete(@PathVariable("id") long id) {
       return userService.userDelete(id);
    }

    @PutMapping("/{id}")
    void updateUser(@RequestBody long id, UserUpdate user) {
        userService.updateUser(id, user);
    }
}
