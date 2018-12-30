package com.kat.lap_trinh_web.controller;

import com.kat.lap_trinh_web.common.model.ClassRoomEntity;
import com.kat.lap_trinh_web.common.model.MemberDto;
import com.kat.lap_trinh_web.common.model.UserEntity;
import com.kat.lap_trinh_web.repository.impl.ClassRoomServiceImpl;
import com.kat.lap_trinh_web.repository.interfaces.ClassRoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Named;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

@Named("classRoom")
@RestController
public class ClassRoomController {


    static ClassRoomEntity classEntity =new ClassRoomEntity();

//    @Autowired
//    ClassRoomService classRoomService;



}
