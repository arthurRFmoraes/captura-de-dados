package com.banksecure.maquina;

import com.banksecure.database.Conexao;
import com.banksecure.usuario.Usuario;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MaquinaDAO {
    private static Looca looca = new Looca();
    private static String macAddress = getMac();

    private Maquina maquina = getMaquina();
    private static Conexao connection = new Conexao();
    private static JdbcTemplate con = connection.getConexaoDoBanco();

    private static String getMac(){
        String mac = "";
        List<RedeInterface> interfacesRede = new ArrayList<>();
        for(RedeInterface o: looca.getRede().getGrupoDeInterfaces().getInterfaces()){
            if(o.getNome().equalsIgnoreCase("eth0") || o.getNome().equalsIgnoreCase("wlp3s0")){
                mac = o.getEnderecoMac();
            }
        }
        looca.getRede().getGrupoDeInterfaces().getInterfaces();
        return mac;
    }
    public static boolean maquinaJaRegistrada(Usuario usuario){
        boolean maquinaRegistrada;
        List<Maquina> maquinas = con.query("""
        select macAddress from maquina join agencia on fkAgencia = idAgencia
        join usuario on usuario.fkEmpresa = agencia.fkEmpresa where macAddress = ? and usuario.email = ?;
        """, new BeanPropertyRowMapper<>(Maquina.class), macAddress, usuario.getEmail());

        maquinaRegistrada = !maquinas.isEmpty();
        return maquinaRegistrada;
    }

    public static void registrarMaquina(int fkAgencia, int fkTipoMaquina, String nome){
        con.update("INSERT INTO maquina (fkAgencia, fkTipoMaquina, macAddress, nome) VALUES (?,?,?,?)",
                fkAgencia, fkTipoMaquina, macAddress, nome);
    }
    public static Maquina getMaquina(){
        List<Maquina> maquinas = con.query("SELECT * FROM maquina WHERE macAddress = ?",
                new BeanPropertyRowMapper<>(Maquina.class), macAddress);
        return maquinas.get(0);
    }



}
