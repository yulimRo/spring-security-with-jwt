package com.yulim.auth.user.service;

import com.yulim.auth.user.dto.UserDTO;
import org.springframework.stereotype.Service;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);
    public UserDTO getUser(Long id);
    public UserDTO updateUser(UserDTO updateUserDTO, Long id);
}
