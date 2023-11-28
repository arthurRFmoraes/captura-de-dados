package com.banksecure.dao;

import com.banksecure.database.ConexaoMysql;
import com.banksecure.model.Agencia;
import com.banksecure.model.Usuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AgenciaDAO {
    private static ConexaoMysql connection = new ConexaoMysql();
    private static JdbcTemplate con = connection.getConexaoDoBanco();

    public static List<Agencia> getAgencias(Usuario u){
        List<Agencia> agencias = con.query("""
                select idAgencia, apelido from agencia JOIN usuario ON usuario.fkEmpresa = agencia.fkEmpresa JOIN
                 funcionarioAgencia ON funcionarioAgencia.fkUsuario = idUsuario AND funcionarioAgencia.fkAgencia =
                  idAgencia WHERE usuario.email = ?;
                """, new BeanPropertyRowMapper<>(Agencia.class), u.getEmail());
        if(agencias.isEmpty()){
            return null;
        }else{
            return agencias;
        }
    }
}
