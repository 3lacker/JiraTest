package ma.ensa.smarthome.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import ma.ensa.smarthome.model.User;
import ma.ensa.smarthome.repository.UserRepository;
import ma.ensa.smarthome.service.UserService;
import ma.ensa.smarthome.dto.UserDTO;
import ma.ensa.smarthome.mapper.UserMapper;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("Fetching all users");
        return  userMapper.toDto(userRepository.findAll());
    }
    @Override
    public Optional<UserDTO> getUserById(Long id) {
        log.info("Fetching user with id: {}", id);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceAccessException("User not found"));

        return Optional.of(userMapper.toDto(user));
    }
    @Override

    public User addUser(UserDTO user) {
        log.info("Adding new user: {}", user.getId());
        return userRepository.save(userMapper.toEntity(user));
    }
    @Override
    public User updateUser(Long id, UserDTO userDto) {
        log.info("Updating userDto with id: {}", id);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceAccessException("User not found"));
/*
    set attribute
*/
        user.setId(userDto.getId());
        return userRepository.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }


}

