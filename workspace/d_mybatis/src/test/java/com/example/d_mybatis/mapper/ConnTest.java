package com.example.d_mybatis.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
public class ConnTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() {

        try {
            Connection connection = dataSource.getConnection();
            log.info("datasource connection : " + connection.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}