package com.kat.lap_trinh_web.service.impl;

import com.kat.lap_trinh_web.common.constant.UserTypeConst;
import com.kat.lap_trinh_web.common.model.LoggedUser;
import com.kat.lap_trinh_web.common.model.UserEntity;
import com.kat.lap_trinh_web.common.util.PasswordUtil;
import com.kat.lap_trinh_web.repository.interfaces.UserRepo;
import com.kat.lap_trinh_web.service.interfaces.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    UserRepo userRepo;

    @Override
    public LoggedUser validateUser(String username, String password) {
        String md5Password = PasswordUtil.hashMD5(password);
        UserEntity userByUsernameAndPassword = userRepo.getUserByUsernameAndPassword(username.toLowerCase(), md5Password);
        if(userByUsernameAndPassword != null) {
            LoggedUser loggedUser = new LoggedUser();
            loggedUser.setUsername(username);
            loggedUser.setUserId(userByUsernameAndPassword.getId());
            if(userByUsernameAndPassword.getPermission() == UserTypeConst.ADMIN || userByUsernameAndPassword.getPermission() == UserTypeConst.CANBO || userByUsernameAndPassword.getPermission() == UserTypeConst.SINHVIEN){
                loggedUser.setUserType(userByUsernameAndPassword.getPermission());
            }
            if(userByUsernameAndPassword.getPermission() == UserTypeConst.DISABLE){
            }
            loggedUser.setEmpName(userByUsernameAndPassword.getName());
            return loggedUser;
        }
        return null;
    }
}
