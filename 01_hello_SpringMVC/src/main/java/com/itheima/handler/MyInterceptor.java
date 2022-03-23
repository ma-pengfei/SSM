package com.itheima.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器类，拦截用户请求
 */
public class MyInterceptor implements HandlerInterceptor {

    private long bTime = 0;
    /**
     *  preHandle:预处理方法。整个项目的入口，返回true，请求可以被处理。返回false，请求到此方法截止。
     *      参数：Object handler 被拦截的控制器对象
     *      返回值：boolean类型
     *          true：
     *              拦截器的preHandle()方法======
     *              拦截器的postHandle()方法======
     *              拦截器的afterCompletion()方法======
     *          false：
     *              拦截器的preHandle()方法======
     *      特点：该方法在控制器方法之前 先执行
     *      作用：在方法中可以获取请求的信息，验证是否符合要求。
     *          如果验证请求，可以截断请求，阻止控制器方法的执行。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        bTime = System.currentTimeMillis();
        System.out.println("11111---拦截器的preHandle()方法======");
//        return false;
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    /**
     *  postHandle:后处理方法
     *      参数：Object handler 被拦截的控制器对象
     *          ModelAndView modelAndView :被拦截的控制器对象的处理器方法的返回值
     *      特点：该方法在控制器方法之后执行
     *      作用：在方法中可以获取处理器方法的返回值，可以修改modelAndView中的数据和视图，影响最后的执行结果。
     *          对原本的对请求的执行结果进行二次修正
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("11111---拦截器的postHandle()方法======");
        if (modelAndView != null) {
            //修改返回的数据
            modelAndView.addObject("addMsg", "添加新的数据");
            //修改返回的视图
            modelAndView.setViewName("other");
        }
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    /**
     *  afterCompletion:最后执行的方法
     *      参数：Object handler 被拦截的控制器对象
     *          Exception exception 程序中发生的异常
     *      特点：在请求处理完成后执行（当视图处理完成后，即对视图执行了forward，认为请求处理完成）
     *          只有在preHandle()方法返回true的情况下，该方法才会执行
     *      作用：在该方法中一般来做资源回收工作。程序过程中创建了一些对象，在这里进行删除，释放被占用的内存
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("11111---拦截器的afterCompletion()方法======");
        long eTime = System.currentTimeMillis();
        System.out.println(eTime-bTime);
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
