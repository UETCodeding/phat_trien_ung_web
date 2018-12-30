package com.kat.lap_trinh_web.controller;


import com.kat.lap_trinh_web.common.model.LoggedUser;
import com.kat.lap_trinh_web.service.interfaces.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named("login")
@ConversationScoped
public class LoginController implements Serializable {

    private String txtUsername, txtPassword;
    private boolean remember;
    private int role = 10;

    @Inject
    AuthorityController authorityController;

    @Inject
    SessionController sessionController;

    @Autowired AuthorityService authorityService;

    public void actLogin() throws IOException {
        LoggedUser loggedUser = authorityService.validateUser(getTxtUsername(), getTxtPassword());
        if(loggedUser == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authenticate error!", "Wrong password."));
        }else{
            authorityController.setLoggedUser(loggedUser);
            sessionController.sessionAndCookie(getTxtUsername());
            role=loggedUser.getUserType();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/");
//            FacesContext.getCurrentInstance().getExternalContext().dispatch("/all_Servey");
        }
    }

    public void actClear(){
        txtUsername = null;
        txtPassword = null;
        remember = false;
    }

    public void actLogout() throws IOException {
        authorityController.setLoggedUser(null);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/logout");
    }

    public String getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}