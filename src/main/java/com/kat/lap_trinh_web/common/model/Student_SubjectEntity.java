package com.kat.lap_trinh_web.common.model;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "student_subject", schema = "public")
public class Student_SubjectEntity {

    private int id;
    private int studentId;
    private int classCode;
    public Student_SubjectEntity(){

    }
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "studentId")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "classCode")
    public int getClassCode() {
        return classCode;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }

}
