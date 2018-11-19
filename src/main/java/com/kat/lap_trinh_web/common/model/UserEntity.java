package com.kat.lap_trinh_web.common.model;

import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "user", schema = "public")
public class UserEntity implements Serializable {
    private String code;
    private Timestamp createdDate;
    private java.util.Date date;
    private Timestamp lastModified;
    private String name;
    private String password;
    private Integer permission;
    private String training;
    private Boolean isPublished;
    private Integer status;
    private String username;
    private String email;
    private int id;

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
        return date;
    }

    public void setBirthDay(Date date) {
        this.date = date;
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
    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Id
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

    @Id
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
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (lastModified != null ? !lastModified.equals(that.lastModified) : that.lastModified != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (permission != null ? !permission.equals(that.permission) : that.permission != null) return false;
        if (training != null ? !training.equals(that.training) : that.training != null) return false;
        if (isPublished != null ? !isPublished.equals(that.isPublished) : that.isPublished != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (permission != null ? permission.hashCode() : 0);
        result = 31 * result + (training != null ? training.hashCode() : 0);
        result = 31 * result + (isPublished != null ? isPublished.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
