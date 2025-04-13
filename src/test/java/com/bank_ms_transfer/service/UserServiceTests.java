package com.bank_ms_transfer.service;

import com.bank_ms_transfer.dto.UserDto;
import com.bank_ms_transfer.entity.UserEntity;
import com.bank_ms_transfer.exception.UserNotFoundException;
import com.bank_ms_transfer.mapper.TransferMapper;
import com.bank_ms_transfer.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository userRepository;
    private TransferMapper transferMapper;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        transferMapper = mock(TransferMapper.class);
        userService = new UserService(userRepository, transferMapper);
    }

    @Test
    void getUserById_shouldReturnUserDto_whenUserExists() {
        Long userId = 1L;
        UserEntity entity = new UserEntity();
        UserDto dto = new UserDto();

        when(userRepository.findById(userId)).thenReturn(Optional.of(entity));
        when(transferMapper.toUserDto(entity)).thenReturn(dto);

        UserDto result = userService.getUserById(userId);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(userRepository).findById(userId);
        verify(transferMapper).toUserDto(entity);
    }

    @Test
    void getUserById_shouldThrowException_whenUserNotFound() {
        Long userId = 2L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(UserNotFoundException.class, () -> userService.getUserById(userId));

        assertEquals("User not found with ID: " + userId, exception.getMessage());
    }

    @Test
    void getAllUser_shouldReturnListOfUserDto() {
        UserEntity user1 = new UserEntity();
        UserEntity user2 = new UserEntity();
        UserDto dto1 = new UserDto();
        UserDto dto2 = new UserDto();

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
        when(transferMapper.toUserDto(user1)).thenReturn(dto1);
        when(transferMapper.toUserDto(user2)).thenReturn(dto2);

        List<UserDto> result = userService.getAllUser();

        assertEquals(2, result.size());
        assertTrue(result.contains(dto1));
        assertTrue(result.contains(dto2));
        verify(userRepository).findAll();
    }

    @Test
    void saveUser_shouldCallSaveWithMappedEntity() {
        UserDto dto = new UserDto();
        UserEntity entity = new UserEntity();

        when(transferMapper.toUserEntity(dto)).thenReturn(entity);

        userService.saveUser(dto);

        verify(userRepository).save(entity);
    }

    @Test
    void deleteUserById_shouldCallRepositoryDelete() {
        Long userId = 5L;

        userService.deleteUserById(userId);

        verify(userRepository).deleteById(userId);
    }
}