package com.tassenabi.restapp.data.config.jdbcconfig;

import java.sql.Connection;

public interface IDatabaseJdbcConnection {

    Connection connection = null;
    Connection getDatabaseConnection();
}