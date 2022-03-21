package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 创建处理器对象：@Controller，并将对象放在springMVC容器中
 * 放在类的上面，和Spring中的@Service，@Component一样
 *
 * 能处理请求的都是控制器(处理器)：MyController能处理请求，叫做后端控制器
 */
@Controller
public class MyController {

    /**
     * 处理用户提交的请求，在springmvc中使用方法处理用户请求。
     * 方法自定义，可以有多种返回值，多种参数，方法名称自定义
     *
     * 准备doSome方法开处理some.do的请求
     * 使用@RequestMapping：请求映射。
     *      将一个请求地址和一个方法绑定在一起，一个请求指定一个方法处理。
     *  属性：value：String类型，表示请求的url地址。必须是唯一的，不能重复
     *
     * RequestMapping修饰的方法叫做处理器方法或者控制器方法，可以处理请求，
     *      类似于Servlet中的doDet，doPost
     *
     * 返回值 ModelAndView:
     *      model：数据，请求处理完成后，要显示给用户的数据。
     *      view：视图，例如jsp等
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){
        //处理some.do的请求
        //假设已经调用service处理完成了
        ModelAndView mv = new ModelAndView();

        //添加数据，框架会在请求的最后把数据放在request作用域中
        //request.setAttribute("msg","欢迎使用SpringMVC进行wen开发");
        mv.addObject("msg","欢迎使用SpringMVC进行web开发");
        mv.addObject("fun","执行doSome方法处理请求");

        //指定视图，指定视图的完整路径，框架会进行forward操作
//        //request.getRequestDispatcher("show.jsp").forward(request,response);
//        mv.setViewName("WEB-INF/view/show.jsp");
//        mv.setViewName("WEB-INF/view/other.jsp");

        //当有多个视图需要制定时，可以在spring配置文件中配置视图解析器简化代码
        //配置了视图解析器后，可以使用逻辑名称(文件名)，指定视图
        mv.setViewName("show");
        //返回ModelAndView
        return mv;
    }

    @RequestMapping(value = {"/other.do","first.do"})
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用SpringMVC进行web开发");
        mv.addObject("fun","执行doSome方法处理请求");
        mv.setViewName("other");
        return mv;
    }

}
