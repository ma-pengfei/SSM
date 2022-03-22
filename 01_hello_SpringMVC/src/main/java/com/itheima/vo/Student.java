package com.itheima.vo;
/**
 * @author Administrator
 * 保存请求参数值的一个普通类
 */
public class Student {

    //属性名和请求参数名一样
    private String username;
    private Integer age;
    private String password;

    public Student() {
        System.out.println("Student的无参构造");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("username = " + username);
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("age = " + age);
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("password = " + password);
        this.password = password;
    }
}
