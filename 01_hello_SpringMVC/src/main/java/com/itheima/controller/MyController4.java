package com.itheima.controller;

import com.itheima.exception.AgeException;
import com.itheima.exception.MyUserException;
import com.itheima.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "user")
@Controller
public class MyController4 {

    @RequestMapping(value = "exception.do")
    @ResponseBody
    public ModelAndView doException(String name, Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();

        if (!"zs".equals(name)) {
            throw new NameException("姓名不正确");
        }

        if (age == null || age >= 80) {
            throw new AgeException("年龄错误");
        }

        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }


}
