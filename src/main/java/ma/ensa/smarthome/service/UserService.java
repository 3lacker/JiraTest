package ma.ensa.smarthome.service;
import ma.ensa.smarthome.model.User;
import ma.ensa.smarthome.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserById(Long id);

    User addUser(UserDTO User);

    User updateUser(Long id, UserDTO UserDto);

    void deleteUser(Long id);
}
