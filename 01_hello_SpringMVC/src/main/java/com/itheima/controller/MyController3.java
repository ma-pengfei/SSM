package com.itheima.controller;

import com.itheima.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class MyController3 {

    /**
     * 返回对象类型，框架转为String的处理流程：
     *     1.调用框架中的ArrayList<HttpMessageConverter>中每个类的canWrite()方法，
     *     检查HttpMessageConverter接口的哪个实现类可以处理该String类型的数据
     *
     *     2.框架调用实现类的write()方法，将字符按照指定的编码处理：text/plain;charset=ISO-8859-1(默认)
     *
     *     3.框架调用@ResponseBody把 2 的结果数据传输到浏览器，ajax请求处理完成。
     *
     * 默认使用text/plain;charset=ISO-8859-1，会出现中文乱码问题。
     *      解决方法，给@RequestMapping注解的 produces 属性指定"text/plain;charset=utf-8"
     */
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age) {
        return "Hello " + name + "，你的年龄是：" + age;
    }

    @RequestMapping(value = "/quick")
    @ResponseBody
    public void doQuick(Date date) {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick1")
    @ResponseBody
    public void doQuick1(HttpServletRequest request, HttpServletResponse response,
                         HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick2")
    @ResponseBody
    public void doQuick2(
            @RequestHeader(value = "User-Agent",required = false)String headerValue) {

        System.out.println("headerValue = " + headerValue);
    }

    @RequestMapping(value = "/quick3")
    @ResponseBody
    public void doQuick3(
            @CookieValue(value = "JSESSIONID",required = false)String jsessionId) {

        System.out.println("jsessionId = " + jsessionId);
    }

}
