package com.itheima.dao;

import com.itheima.pojo.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectStudents();
}
