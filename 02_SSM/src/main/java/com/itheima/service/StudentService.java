package com.itheima.service;

import com.itheima.pojo.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    List<Student> selectStudents();
}
