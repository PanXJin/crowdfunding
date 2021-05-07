package com.atguigu.crowd.test;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author PanX
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class test {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void textAdmin() {
        Admin admin = new Admin(null, "Panx", "123", "PanX", "123@qq.com", null);
        int count = adminMapper.insert(admin);
        System.out.println("受影响的行数："+count);
    }

    @Test
    public void textConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
