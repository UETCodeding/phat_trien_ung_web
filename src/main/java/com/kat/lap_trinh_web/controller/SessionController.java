package com.kat.lap_trinh_web.controller;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Named("session")
@SessionScoped
public class SessionController implements Serializable {

    @PostConstruct
    public void init(){

    }

    public void sessionAndCookie(String userName){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.setAttribute("Name", userName);
        Cookie cookie = new Cookie("user", userName);
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
    }
}
