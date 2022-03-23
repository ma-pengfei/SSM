package com.itheima.controller;

import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService service;
    /**
     *  注册学生
     */
    @RequestMapping("addStudent")
    public ModelAndView addStudent(Student student){
        String tips = "注册失败";
        int nums = service.addStudent(student);
        if (nums > 0) {
            tips = "学生【" + student.getName() +"】 注册成功!";
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips", tips);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("listStudent")
    @ResponseBody
    public List<Student> selectStudent(){
        ModelAndView mv = new ModelAndView();
        return service.selectStudents();
    }
}
