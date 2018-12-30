package com.kat.lap_trinh_web.common.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "subject_rate", schema = "public")
public class SubjectRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rateId;
    private int classCode;
    private String title;
    private double diem1;
    private double diem2;
    private double diem3;
    private double diem4;
    private double diem5;
    private int numberRate;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rateId")
    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    @Basic
    @Column(name = "classCode")
    public int getClassCode() {
        return classCode;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "diem1")
    public double getDiem1() {
        return diem1;
    }

    public void setDiem1(double diem1) {
        this.diem1 = diem1;
    }

    @Basic
    @Column(name = "diem2")
    public double getDiem2() {
        return diem2;
    }

    public void setDiem2(double diem2) {
        this.diem2 = diem2;
    }

    @Basic
    @Column(name = "diem3")
    public double getDiem3() {
        return diem3;
    }

    public void setDiem3(double diem3) {
        this.diem3 = diem3;
    }

    @Basic
    @Column(name = "diem4")
    public double getDiem4() {
        return diem4;
    }

    public void setDiem4(double diem4) {
        this.diem4 = diem4;
    }

    @Basic
    @Column(name = "diem5")
    public double getDiem5() {
        return diem5;
    }

    public void setDiem5(double diem5) {
        this.diem5 = diem5;
    }

    @Basic
    @Column(name = "numberRate")
    public int getNumberRate() {
        return numberRate;
    }

    public void setNumberRate(int numberRate) {
        this.numberRate = numberRate;
    }
}