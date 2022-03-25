package com.itheima.jdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class TestJdbcTemplate {

    @Test
    public void test1() throws PropertyVetoException {
        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///db1");
        dataSource.setUser("root");
        dataSource.setPassword("mpf990530");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        int row = jdbcTemplate.update("insert into account(name,money) values(?,?)", "Mark", 3000.00);
        System.out.println("row = " + row);


    }

    @Test
    public void test2(){
        String config = "spring.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(config);

        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");

        int row = jdbcTemplate.update("insert into account(name,money) values(?,?)", "Alice", 8000.21);
        System.out.println("row = " + row);
    }
}
