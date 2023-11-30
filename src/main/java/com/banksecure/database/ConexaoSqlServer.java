package com.banksecure.database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
public class ConexaoSqlServer {
    private JdbcTemplate conexaoDoBanco;

    public ConexaoSqlServer() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:sqlserver://52.5.117.13:1433;databaseName=bankSecure");
        dataSource.setUsername("sa");
        dataSource.setPassword("urubu100");

        conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }
}
