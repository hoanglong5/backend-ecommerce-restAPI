package com.hoanglong.backendecommercerestapi.Database;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class DatabaseConnectionTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testDatabaseConnection() {
        assertNotNull(jdbcTemplate);
    }
}
