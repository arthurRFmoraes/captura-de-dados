package com.banksecure.database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
public class ConexaoMysql {
    //classe responsavel pela conexao com o bd

    private JdbcTemplate conexaoDoBanco;

    public ConexaoMysql() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bankSecure");
        dataSource.setUsername("user_bankSecure");
        dataSource.setPassword("Urubu_100");

        conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }
}

