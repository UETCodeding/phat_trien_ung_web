package com.kat.lap_trinh_web.controller;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("session")
@SessionScoped
public class SessionController implements Serializable {

    @PostConstruct
    public void init(){

    }
}
