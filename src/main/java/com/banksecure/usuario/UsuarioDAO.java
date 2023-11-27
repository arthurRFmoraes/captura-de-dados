package com.banksecure.usuario;

import com.banksecure.database.Conexao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static Conexao connection = new Conexao();
    private static JdbcTemplate con = connection.getConexaoDoBanco();

    public static Usuario login(Usuario usuario){
        List<Usuario> usuarios = new ArrayList<>();

        usuarios = con.query("""
                SELECT * FROM usuario WHERE email = ? AND senha = ?;
                """, new BeanPropertyRowMapper<>(Usuario.class), usuario.getEmail(), usuario.getSenha());
        if(usuarios.isEmpty()){
            System.out.println("Email e/ou senha incorretos.");
            return null;
        }else{
            return usuarios.get(0);
        }
    }


}
