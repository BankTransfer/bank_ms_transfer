package com.bank_ms_transfer.controller;

import com.bank_ms_transfer.dto.UserDto;
import com.bank_ms_transfer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAllUser();
    }

    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @DeleteMapping
    public void deleteById(Long id) {
        userService.deleteUserById(id);
    }
}
