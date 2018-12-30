package com.kat.lap_trinh_web.repository.impl;

import com.kat.lap_trinh_web.common.model.ClassRoomEntity;
import com.kat.lap_trinh_web.repository.interfaces.ClassRoomService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClassRoomServiceImpl implements ClassRoomService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ClassRoomEntity classRoomEntity){
        entityManager.merge(classRoomEntity);
    }
}
