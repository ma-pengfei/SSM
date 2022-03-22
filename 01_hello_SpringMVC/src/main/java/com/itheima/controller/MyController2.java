package com.itheima.controller;

import com.itheima.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RequestMapping(value = "test")
@Controller
public class MyController2 {

    /**
     *   请求映射@RequestMapping 指定请求的方式：
     *      属性 method 表示请求的方式。值为 RequestMethod类的枚举值
     *      例如 Get方式 : RequestMethod.GET
     *          Post方式 : RequestMethod.POST
     *
     *      只有当访问方式需要指定为Post时，可以使用
     *      否则不推荐使用，如果制定了访问方式，前端访问方式不符合的话可能会报错405
     *      不指定请求方式时，使用任何方式访问都可以
     */
    @RequestMapping(value = "first.do",method = RequestMethod.GET)
    public ModelAndView doFirst(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用SpringMVC进行web开发");
        mv.addObject("fun","执行doSome方法处理请求");
        mv.setViewName("show");
        return mv;
    }

    /**
     *  当需要接收用户提交的参数时，可以给方法定义参数：
     *  HttpServletRequest request
     *  HttpServletResponse response
     *  HttpSession session
     *  调用该方法时，框架会自动给这三个参数赋值
     */
    @RequestMapping(value ="second.do",method = RequestMethod.POST)
    public ModelAndView doSecond(HttpServletRequest request,
                                 HttpServletResponse response,
                                 HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用SpringMVC进行web开发");
        mv.addObject("fun","执行doSecond方法处理请求");
        mv.addObject("attr",request.getParameter("username"));
        mv.setViewName("other");
        return mv;
    }

    /**
     *  接收参数的两种方式：
     *      1.逐个接收请求参数；
     *          要求：@RequestMapping修饰的处理器(控制器)方法的形参名必须和请求的参数名一致
     *              同名的请求参数将自动赋值给同名的形参
     *      当不确定普通类型的参数有没有时，建议使用包装类
     *
     *      当请求中参数名和处理器方法的形参名不一致时，使用@RequestParam注解
     *      属性：value 请求中的参数的名称
     *           required boolean类型，默认为true，表示请求中必须包含此参数
     *      位置：在处理器方法的形参定义前面
     */
    @RequestMapping(value ="third.do")
    public ModelAndView doThird(@RequestParam(value = "username1",required = false) String username,
                                @RequestParam(value = "password1",required = false) String password,
                                @RequestParam(value = "age1",required = false) Integer age) {
        //在提交请求参数时,get请求由于tomcat服务器不会出现乱码
        //而post请求会出现中文乱码问题，可以通过设置setCharacterEncoding来解决
        //但每个方法都需要这样设置过于麻烦，可以通过配置过滤器来解决(可以自定义，也可以使用框架中提供的)
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用SpringMVC进行web开发");
        mv.addObject("fun","执行doThird方法处理请求");
        mv.addObject("username",username);
        mv.addObject("password",password);
        mv.addObject("age",age);
        mv.setViewName("other");
        return mv;
    }

    /**
     *  2.对象参数接收
     *  当接收很多参数时，可以封装为一个对象，一次性全部接收。
     *  处理器方法的形参是java对象，这个对象的属性名和请求参数的参数名一致
     *  框架会自动创建形参的对象，给属性赋值。请求中的参数为age，框架会调用setAge()
     *  不能使用@RequestParam注解
     */
    @RequestMapping(value ="fourth.do")
    public ModelAndView doFourth(Student student) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username",student.getUsername());
        mv.addObject("password",student.getPassword());
        mv.addObject("age",student.getAge());
        mv.setViewName("other");
        return mv;
    }


}
