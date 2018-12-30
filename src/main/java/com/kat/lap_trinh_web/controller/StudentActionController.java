package com.kat.lap_trinh_web.controller;
import com.kat.lap_trinh_web.common.constant.MessageErrorConst;
import com.kat.lap_trinh_web.common.model.UserDto;
import com.kat.lap_trinh_web.common.model.UserEntity;
import com.kat.lap_trinh_web.common.util.DateValidator;
import com.kat.lap_trinh_web.common.util.EmailValidator;
import com.kat.lap_trinh_web.common.util.FileUtil;
import com.kat.lap_trinh_web.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.annotation.PostConstruct;
//import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@Named("student")
@ViewScoped
public class StudentActionController {
    private int idToDelete;
    private List<UserDto> studentDtoList;
    ServletContext servletContext;
    @Autowired
    UserService userService;

    @Autowired
    ServletContext context;

    @PostConstruct
    public void init() {
        studentDtoList = findAllStudent();

    }
    public List<UserDto> findAllStudent(){
        return this.studentDtoList = userService.findAllStudent();
    }

    public void deleteStudent() {
        userService.delete(this.idToDelete);
        Iterator<UserDto> i = studentDtoList.iterator();
        while(i.hasNext()) {
            UserDto s = i.next(); // must be called before you can call i.remove()
            if(s.getUserId() == this.idToDelete) {
                i.remove();
            }
        }
    }
    public int getIdToDelete() {
        return idToDelete;
    }


    public void setIdToDelete(int idToDelete) {
        this.idToDelete = idToDelete;
    }

    public List<UserDto> getStudentDtoList() {
        return studentDtoList;
    }

    public void setStudentDtoList(List<UserDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }

}
