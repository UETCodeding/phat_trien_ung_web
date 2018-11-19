package com.kat.lap_trinh_web.controller;
import com.kat.lap_trinh_web.common.constant.MessageErrorConst;
import com.kat.lap_trinh_web.common.model.UserDto;
import com.kat.lap_trinh_web.common.util.DateValidator;
import com.kat.lap_trinh_web.common.util.EmailValidator;
import com.kat.lap_trinh_web.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Named("lecturers")
@ViewScoped
public class UserActionController  implements Serializable {
    UserDto userDto;
    UserDto userRequestDto;
    List<UserDto> lecturersDtoList;
    String idRequest;

    @Autowired
    UserService userService;

    @PostConstruct
    public void init() {}

    public List<UserDto> findAllLecturers(){
        return this.lecturersDtoList = userService.findAllLecturers();
    }

    public List<UserDto> findAllStudent(){
        return this.lecturersDtoList = userService.findAllStudent();
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
    public void displayEmptyError(String componentId){
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("displayError('main\\\\:" + componentId + "', 'Can not be empty!')");
    }

    public void displayError(String componentId, String message){
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("displayError('main\\\\:" + componentId + "', '" + message + "')");
    }

    public void hiddenError(String componentId){
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("hiddenError('main\\\\:"+componentId +"')");
    }
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

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }
}
