package com.banksecure.database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
public class ConexaoSqlServer {
    private JdbcTemplate conexaoDoBanco;

    public ConexaoSqlServer() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bankSecure");
        dataSource.setUsername("user_bankSecure");
        dataSource.setPassword("Urubu_100");

        conexaoDoBanco = new JdbcTemplate(dataSource);
    }
}
