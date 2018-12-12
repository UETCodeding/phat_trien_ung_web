package com.kat.lap_trinh_web.common.model;

import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
public class UserEntity implements Serializable {
    @Id
    private int code;

    private Timestamp createdDate;
    private java.util.Date birthday;
    private Timestamp lastModified;
    private String name;
    private String password;
    private int permission;
    private String training;
    private Boolean isPublished;
    private int status;
    private String username;
    private String email;
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "class_member", joinColumns = @JoinColumn(name = "member_code", referencedColumnName = "code"), inverseJoinColumns = @JoinColumn(name = "class_code", referencedColumnName = "classCode"))
    private Set<ClassRoomEntity> classRoomEntities;

    public UserEntity(){}

    public UserEntity(String name){
        this.name = name;
    }

    public UserEntity(String name, Set<ClassRoomEntity> classRoomEntities){
        this.name = name;
        this.classRoomEntities=classRoomEntities;
    }

//    @Id
//    @Column(name = "code")
//    public int getCode() {
//        return code;
//    }
//
    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "created_date")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "birthday")
    public java.util.Date getBirthDay() {
        return birthday;
    }

    public void setBirthDay(Date date) {
        this.birthday = date;
    }

    @Basic
    @Column(name = "last_modified")
    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "permission")
    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "training")
    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    @Basic
    @Column(name = "is_published")
    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "value_to_search")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<ClassRoomEntity> getClassRoomEntities() {
//        return classRoomEntities;
//    }
//
//    public void setClassRoomEntities(Set<ClassRoomEntity> classRoomEntities) {
//        this.classRoomEntities = classRoomEntities;
//    }

    @Basic
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (code != that.code) return false;
        if (permission != that.permission) return false;
        if (status != that.status) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (lastModified != null ? !lastModified.equals(that.lastModified) : that.lastModified != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (training != null ? !training.equals(that.training) : that.training != null) return false;
        if (isPublished != null ? !isPublished.equals(that.isPublished) : that.isPublished != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code ;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + permission;
        result = 31 * result + (training != null ? training.hashCode() : 0);
        result = 31 * result + (isPublished != null ? isPublished.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
