package com.itheima.handler;

import com.itheima.exception.AgeException;
import com.itheima.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg",exception.getMessage());
        mv.addObject("exception",exception);
        mv.setViewName("nameException");
        return mv;
    }

    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","无效年龄或年龄过大");
        mv.addObject("exception",exception);
        mv.setViewName("ageException");
        return mv;
    }

    @ExceptionHandler
    public ModelAndView doDefaultException(Exception exception){
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg",exception.getMessage());
        mv.addObject("exception",exception);
        mv.setViewName("exception");
        return mv;
    }
}
