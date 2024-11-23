package com.yulim.auth.user.mapper;

import com.yulim.auth.user.dto.UserDTO;
import com.yulim.auth.user.entity.User;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class UserMapper {

    public User toEntity(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .userId(userDTO.getUserId())
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .build();
    }

    public UserDTO toDTO(User userEntity) {
        return UserDTO.builder()
                .id(userEntity.getId())
                .userId(userEntity.getUserId())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .createDate(userEntity.getCreateDate() != null ? userEntity.getCreateDate().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) : "")
                .creatorId(userEntity.getCreatorId())
                .updateDate(userEntity.getUpdateDate() != null ? userEntity.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) : "")
                .updateId(userEntity.getUpdaterId())
                .build();
    }

    public void update(User existingUser, UserDTO userDTO){
        existingUser.setUserName(userDTO.getUserName());
    }
}
