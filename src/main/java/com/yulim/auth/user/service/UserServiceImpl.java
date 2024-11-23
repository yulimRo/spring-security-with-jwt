package com.yulim.auth.user.service;

import com.yulim.auth.user.dto.UserDTO;
import com.yulim.auth.user.entity.User;
import com.yulim.auth.user.mapper.UserMapper;
import com.yulim.auth.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);

        User newUser = userRepository.save(user);
        return userMapper.toDTO(newUser);
    }

    @Override
    public UserDTO getUser(Long id) {
        User user =  userRepository.findById(id).orElseThrow( () -> new NullPointerException("사용자 정보가 없습니다."));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO updateUserDTO, Long id) {
        if(id != updateUserDTO.getId()){
            throw new IllegalArgumentException("사용자 정보가 올바르지 않습니다.");
        }

        User existingUser = userRepository.findById(updateUserDTO.getId()).orElseThrow(() -> new EntityNotFoundException("사용자 정보가 없습니다."));

        userMapper.update(existingUser, updateUserDTO);

        User updateUser = userRepository.save(existingUser);

        return userMapper.toDTO(updateUser);
    }
}
