package com.kat.lap_trinh_web.common.model;

//import com.sun.faces.util.Json;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "class_room", schema = "public")
public class ClassRoomEntity implements Serializable {
    private int id;
    private int number_of_credits;
    private String className;
    private String classCode;
    private String lecturer;
    private String lecturerId;
    private String lesson;
    private String amphitheater;
    private Timestamp createDate;
    private Timestamp updated;
    private String note;

    public ClassRoomEntity(){}

    public ClassRoomEntity(String className){
        this.className=className;
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

    @Basic
    @Column(name = "number_of_credits")
    public int getNumber_of_credits() {
        return number_of_credits;
    }

    public void setNumber_of_credits(int number_of_credits) {
        this.number_of_credits = number_of_credits;
    }

    @Basic
    @Column(name = "className")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "classCode")
    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Basic
    @Column(name = "lecturer")
    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Basic
    @Column(name = "lecturerId")
    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    @Basic
    @Column(name = "lesson")
    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @Basic
    @Column(name = "amphitheater")
    public String getAmphitheater() {
        return amphitheater;
    }

    public void setAmphitheater(String amphitheater) {
        this.amphitheater = amphitheater;
    }

    @Basic
    @Column(name = "createCreateDate")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "updated")
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassRoomEntity that = (ClassRoomEntity) o;

        if (id != that.id) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (classCode != null ? !classCode.equals(that.classCode) : that.classCode != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (lecturer != null ? !lecturer.equals(that.lecturer) : that.lecturer != null) return false;
        if (lecturerId != null ? !lecturerId.equals(that.lecturerId) : that.lecturerId != null) return false;
        if (lesson != null ? !lesson.equals(that.lesson) : that.lesson != null) return false;
        if (amphitheater != null ? !amphitheater.equals(that.amphitheater) : that.amphitheater != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;
//        if (memberList != null ? !memberList.equals(that.memberList) : that.memberList != null) return false;
        if (number_of_credits != that.number_of_credits ) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = className != null ? className.hashCode() : 0;
        result = 31 * result + (classCode != null ? classCode.hashCode() : 0);
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        result = 31 * result + (lecturerId != null ? lecturerId.hashCode() : 0);
        result = 31 * result + (lesson != null ? lesson.hashCode() : 0);
        result = 31 * result + (amphitheater != null ? amphitheater.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + number_of_credits;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Class_Room [code=%s, name='%s']%n",
                classCode, className);
        return result;
    }
}
