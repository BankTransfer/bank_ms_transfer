package com.bank_ms_transfer.service;

import com.bank_ms_transfer.dto.UserDto;
import com.bank_ms_transfer.entity.UserEntity;
import com.bank_ms_transfer.exception.UserAlreadyExistsException;
import com.bank_ms_transfer.exception.UserNotFoundException;
import com.bank_ms_transfer.mapper.TransferMapper;
import com.bank_ms_transfer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final TransferMapper transferMapper;

    public UserDto getUserById(Long id) {
        log.info("Get card to card by ID: {}", id);
        return transferMapper
                .toUserDto(userRepository
                        .findById(id)
                        .orElseThrow(() -> new UserNotFoundException(id)));
    }

    public List<UserDto> getAllUser() {
        log.info("Get all users");
        return userRepository
                .findAll()
                .stream()
                .map(transferMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public void saveUser(UserDto userDto) {
        List<UserEntity> allUsers = userRepository.findAll();
        boolean userExists = allUsers.stream()
                .anyMatch(user -> user.getEmail().equals(userDto.getEmail()));

        if (userExists) {
            throw new UserAlreadyExistsException("User already exists with email: " + userDto.getEmail());
        }

        userRepository.save(transferMapper.toUserEntity(userDto));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
