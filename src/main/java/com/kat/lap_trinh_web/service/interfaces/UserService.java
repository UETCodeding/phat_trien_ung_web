package com.kat.lap_trinh_web.service.interfaces;

import com.kat.lap_trinh_web.common.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    List<UserDto> findAllLecturers();
    List<UserDto> findAllStudent();
    UserDto findById(int id);
    UserDto findByEmail(String email);
    UserDto findByUserName(String username);
    void save(UserDto userDto);
    void delete(Integer userId);
}
