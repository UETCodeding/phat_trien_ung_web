package com.kat.lap_trinh_web.service.impl;

import com.kat.lap_trinh_web.common.model.UserDto;
import com.kat.lap_trinh_web.common.model.UserEntity;
import com.kat.lap_trinh_web.common.util.CommonUtil;
import com.kat.lap_trinh_web.common.util.PasswordUtil;
import com.kat.lap_trinh_web.common.util.DateUtil;
import com.kat.lap_trinh_web.repository.interfaces.UserRepo;
import com.kat.lap_trinh_web.service.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream().map(this::TsUser2UserDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllLecturers(){
        return userRepo.findAllLecturers().stream().map(this::TsUser2UserDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllStudent(){
        return userRepo.findAllStudent().stream().map(this::TsUser2UserDto).collect(Collectors.toList());
    }
    @Override
    public UserDto findById(int id){
        UserEntity result = userRepo.findById(id);
        UserDto userDto = new UserDto();
        if(result != null) {
            userDto.setFullName(result.getName());
            userDto.setEmail(result.getEmail());
            userDto.setBirthday(result.getBirthDay());
            userDto.setUserId(result.getId());
            userDto.setStatus(result.getStatus());
            userDto.setUserType(result.getPermission());
            userDto.setTraining(result.getTraining());
            userDto.setCode(result.getCode());
            userDto.setPassword(result.getPassword());
        } else {
            userDto = null;
        }
        return userDto;
    }
    @Override
    public UserDto findByEmail(String email){
        UserEntity result = userRepo.findByEmail(email);
        UserDto userDto = new UserDto();
        if(result != null) {
            userDto.setFullName(result.getName());
            userDto.setEmail(result.getEmail());
            userDto.setBirthday(result.getBirthDay());
            userDto.setUserId(result.getId());
            userDto.setStatus(result.getStatus());
            userDto.setUserType(result.getPermission());
            userDto.setTraining(result.getTraining());
            userDto.setCode(result.getCode());
            userDto.setPassword(result.getPassword());
        } else {
            userDto = null;
        }
        return userDto;
    }

    @Override
    public UserDto findByUserName(String username){
        UserEntity result = userRepo.findByUserName(username);
        UserDto userDto = new UserDto();
        if(result != null) {
            userDto.setFullName(result.getName());
            userDto.setEmail(result.getEmail());
            userDto.setBirthday(result.getBirthDay());
            userDto.setUserId(result.getId());
            userDto.setStatus(result.getStatus());
            userDto.setUserType(result.getPermission());
            userDto.setTraining(result.getTraining());
            userDto.setCode(result.getCode());
            userDto.setPassword(result.getPassword());
        } else {
            userDto = null;
        }
        return userDto;
    }

    @Override
    public void save(UserDto userDto) {
        UserEntity savingObj = userRepo.findById(userDto.getUserId());
        if(savingObj == null){
            savingObj = new UserEntity();
            savingObj.setId(userDto.getUserId());
        }
        savingObj.setUsername(userDto.getUserName());
        savingObj.setPermission(userDto.getUserType());
        savingObj.setCode(userDto.getCode());
        savingObj.setStatus(userDto.getStatus());
        savingObj.setName(userDto.getFullName());
        savingObj.setCreatedDate(DateUtil.getCurrentDayTS());
        savingObj.setBirthDay(userDto.getBirthday());
        savingObj.setEmail(userDto.getEmail());
        if(!CommonUtil.isNull(userDto.getPassword())){
            savingObj.setPassword(PasswordUtil.hashMD5(userDto.getPassword()));
        }
        if(userDto.getUserType()==2){
            savingObj.setTraining(userDto.getTraining());
        }
        userRepo.save(savingObj);
    }

    @Override
    public void delete(Integer userId) {
        UserEntity deletingObj = userRepo.findById(userId);
        userRepo.delete(deletingObj);
    }

    private UserDto TsUser2UserDto(UserEntity input){
        UserDto map = modelMapper.map(input, UserDto.class);
        map.setStatus(input.getStatus());
        map.setUserName(input.getUsername());
        map.setUserId(input.getId());
        map.setFullName(input.getName());
        map.setUserType(input.getPermission());
        map.setEmail(input.getEmail());
        map.setTraining(input.getTraining());
        map.setBirthday(input.getBirthDay());
        map.setTraining(input.getTraining());
        return map;
    }
}
