package com.banksecure.maquina;

import com.banksecure.database.Conexao;
import com.github.britooo.looca.api.core.Looca;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class MaquinaDAO {
    private static Looca looca = new Looca();
    private static String macAddress = "1-1-1";
//    looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoMac()
    private Maquina maquina = getMaquina();
    private static Conexao connection = new Conexao();
    private static JdbcTemplate con = connection.getConexaoDoBanco();

    public static Maquina getMaquina(){
        List<Maquina> maquinas = con.query("SELECT * FROM maquina WHERE macAddress = ?",
                new BeanPropertyRowMapper<>(Maquina.class), macAddress);
        return maquinas.get(0);
    }



}
