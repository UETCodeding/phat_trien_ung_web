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
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@Named("studentEdit")
@RestController
@RequestMapping
@ViewScoped
public class StudentEditController {
    private UserDto studentToEdit;
    private int idToDelete;
    ServletContext servletContext;
    @Autowired
    UserService userService;

    @Autowired
    ServletContext context;

    @PostConstruct
    public void init() {
        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        studentToEdit = userService.findById(Integer.valueOf(req.getParameter("id")));
    }
    public void save() throws IOException {
        userService.save(studentToEdit);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/department");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserDto getStudentToEdit() {
        return studentToEdit;
    }

    public void setStudentToEdit(UserDto studentToEdit) {
        this.studentToEdit = studentToEdit;
    }

    public int getIdToDelete() {
        return idToDelete;
    }

    public void setIdToDelete(int idToDelete) {
        this.idToDelete = idToDelete;
    }
}
