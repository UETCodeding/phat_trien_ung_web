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

import javax.annotation.PostConstruct;
//import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@Named("user")
@RestController
@RequestMapping
public class UserActionController  extends MessageErrorConst {
    UserDto userDto;
    UserDto userRequestDto;
    List<UserDto> lecturersDtoList;
    List<UserDto> studentDtoList;
    List<UserDto> list;
    String idRequest;
    ServletContext servletContext;

    @Autowired
    UserService userService;

    @Autowired
    ServletContext context;

    @PostConstruct
    public void init() {
        studentDtoList = findAllStudent();
    }

    public List<UserDto> findAllLecturers(){
        return this.lecturersDtoList = userService.findAllLecturers();
    }

    public List<UserDto> findAllStudent(){
        return this.studentDtoList = userService.findAllStudent();
    }

    public UserDto findById(int id){
        return this.userDto = userService.findById(id);
    }

    public UserDto findByUserName(String username){
        return userService.findByUserName(username);
    }

    public void deleteLecturers() {
        userService.delete(userRequestDto.getUserId());
        Iterator<UserDto> i = lecturersDtoList.iterator();
        while(i.hasNext()) {
            UserDto s = i.next(); // must be called before you can call i.remove()
            if(s.getEmail() == this.idRequest) {
                i.remove();
            }
        }
    }

    @Description("import list students by file excel")
    @PostMapping(value = "/studentExcel")
    public String importStudentExcel(@RequestParam("file") MultipartFile file) {
        FileUtil fileUtil = new FileUtil();
        this.list = userService.findAll();
        int size = list.size();
        // Student.Permission = 2
        List<UserEntity> list = fileUtil.ExcelHelper(file,size,2);
        for(int i=0;i<list.size();i++){
            userService.save(list.get(i));
        }
        return "test import student excel";
    }

    @Description("import list lecturers by file excel")
    @RequestMapping(value = "/lecturersExcel",method = RequestMethod.POST)
    public String importLecturersExcel(@RequestParam("file") MultipartFile file) {
        FileUtil fileUtil = new FileUtil();
        this.list = userService.findAll();
        int size = list.size();
        // Lecturers.Permission = 3
        List<UserEntity> list = fileUtil.ExcelHelper(file,size,3);
        for(int i=0;i<list.size();i++){
            userService.save(list.get(i));
        }
        return "test import lecturers excel";
    }

    //dowload file or save file on local
    private String saveExcelFile(MultipartFile file){
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(servletContext.getRealPath("/resources/excels" +file));
            Files.write(path,bytes);
            return file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Check validate
    private boolean validate() {
        boolean isValid = true;
        if(userRequestDto.getEmail() == null || userRequestDto.getEmail().equals("")) {
            isValid = false;
            displayEmptyError("txtUserEmail");
        } else {
            isValid = true;
            hiddenError("txtUserEmail");
            EmailValidator emailValidator = new EmailValidator();

            if(!emailValidator.validate(userRequestDto.getEmail())) {
                isValid &= false;
                displayError("txtUserEmail", "Invalid format!");
            }
            if(userService.findByEmail(userRequestDto.getEmail()) != null) {
                isValid = false;
                displayError("txtUserEmail", "This email exists!");
            }
        }

        if(userRequestDto.getFullName() == null || userRequestDto.getFullName().equals("")) {
            isValid = false;
            displayEmptyError("txtUserName");
        } else {
            hiddenError("txtUserName");
        }

        if(userRequestDto.getUserType() >3 || userRequestDto.getUserType() < 0) {
            isValid = false;
            displayEmptyError("txtPosition");
        } else {
            isValid = true;
            hiddenError("txtPosition");
        }
        DateValidator dateValidator = new DateValidator();
        if(dateValidator.isThisDateValid(userRequestDto.getBirthdayToString(),"{0:dd/mm/yyyy}")) {
            isValid &= true;
            hiddenError("txtBirthDay");
        } else {
            isValid = false;
            displayError("txtBirthDay","không đúng định dạng!");
        }

        return isValid;
    }
    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public UserDto getUserRequestDto() {
        return userRequestDto;
    }

    public void setUserRequestDto(UserDto userRequestDto) {
        this.userRequestDto = userRequestDto;
    }

    public List<UserDto> getlecturersDtoList() {
        return lecturersDtoList;
    }

    public void setlecturersDtoList(List<UserDto> lecturersDtoList) {
        this.lecturersDtoList = lecturersDtoList;
    }

    public List<UserDto> getList() {
        return list;
    }

    public void setList(List<UserDto> list) {
        this.list = list;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }

    public List<UserDto> getStudentDtoList() {
        return studentDtoList;
    }

    public void setStudentDtoList(List<UserDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }
}
