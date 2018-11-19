package com.kat.lap_trinh_web.repository.interfaces;

import com.kat.lap_trinh_web.common.model.UserEntity;

import java.util.List;

public interface UserRepo {
    UserEntity getUserByUsernameAndPassword(String username, String md5_password);
    List<UserEntity> findAll();
    List<UserEntity> findAllLecturers();
    List<UserEntity> findAllStudent();
    UserEntity findById(Integer userId);
    UserEntity findByEmail(String email);
    UserEntity findByUserName(String username);
    void save(UserEntity userEntity);
    void delete(UserEntity userEntity);
}
