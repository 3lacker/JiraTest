package ma.ensa.smarthome.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ma.ensa.smarthome.dto.UserDTO;
import ma.ensa.smarthome.model.User;

@Component
public class UserMapper {
    public UserDTO toDto(User entity) {
        return UserDTO.builder()
                .id(entity.getId())
/*              continue */
                .build();
    }

    public User toEntity(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
/*              continue */

                .build();
    }
     public List<User> toEntity(List<UserDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
    public List<UserDTO> toDto(List<User> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
