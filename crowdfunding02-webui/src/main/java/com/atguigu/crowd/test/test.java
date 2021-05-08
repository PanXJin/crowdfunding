package com.atguigu.crowd.test;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public void textLog() {
        //1、获取logger对象,通常传入的class对象就是当前打印日志的类
        Logger logger = LoggerFactory.getLogger(test.class);
        //2、根据不同日志级别打印日志
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    @Test
    public void textAdmin() {
        Admin admin = new Admin(null, "Panx", "123", "PanX", "123@qq.com", null);
        int count = adminMapper.insert(admin);
        /*
         * 如果在实际开发中查看数值都是用out会消耗很多性能，因为out是IO操作
         * 即使上线前花时间删除代码重的out也可能会有遗漏且麻烦
         * 如果使用日志就可以通过日志级别就可以进行批量的打印*/
//        System.out.println("受影响的行数："+count);
        Logger logger = LoggerFactory.getLogger(test.class);
        //2、根据不同日志级别打印日志
        logger.error("受影响的行数："+count);
    }

    @Test
    public void textConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
