package com.itheima.jdbcTemplate;

import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        int row = jdbcTemplate.update("update account set money= ? where name = ?", 10000.00, "Mark");
        System.out.println("row = " + row);
    }

    @Test
    public void testDelete() {
        int row = jdbcTemplate.update("delete from account where name = ?", "Mark");
        System.out.println("row = " + row);
    }

    @Test
    public void testInsert() {
        int row = jdbcTemplate.update("insert into account values(?,?)", "Mark", 8000);
        System.out.println("row = " + row);
    }

    @Test
    public void testSelectAll() {
        List<Account> accounts = jdbcTemplate.query("select name, money from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accounts) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void testSelectByName() {
        Account account = jdbcTemplate.queryForObject("select name, money from account where name=?", new BeanPropertyRowMapper<>(Account.class), "Mark");
        System.out.println("account = " + account);
    }

    @Test
    public void testSelectCount() {
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println("count = " + count);
    }

}
