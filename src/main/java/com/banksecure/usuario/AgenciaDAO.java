package com.banksecure.usuario;

import com.banksecure.database.Conexao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {
    private static Conexao connection = new Conexao();
    private static JdbcTemplate con = connection.getConexaoDoBanco();

    public static List<Agencia> getAgencias(Usuario u){
        List<Agencia> agencias = con.query("""
                select apelido from agencia JOIN usuario ON usuario.fkEmpresa = agencia.fkEmpresa JOIN
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
