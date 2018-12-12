package com.kat.lap_trinh_web.service.interfaces;

import com.kat.lap_trinh_web.common.model.UserDto;
import com.kat.lap_trinh_web.common.model.UserEntity;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    List<UserDto> findAllLecturers();
    List<UserDto> findAllStudent();
    UserDto findById(int id);
    UserDto findByEmail(String email);
    UserDto findByUserName(String username);
    void save(UserDto userDto);
    void save (UserEntity userEntity);
    void delete(Integer userId);
}
