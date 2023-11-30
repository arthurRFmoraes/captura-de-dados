package com.banksecure.dao;

import com.banksecure.database.ConexaoSqlServer;
import com.banksecure.model.Maquina;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class MaquinaSqlServerDAO {
    private static Looca looca = new Looca();
    private static String macAddress = getMac();

    private Maquina maquina = getMaquina();
    private static ConexaoSqlServer connection = new ConexaoSqlServer();
    private static JdbcTemplate con = connection.getConexaoDoBanco();

    private static String getMac() {
        String mac = "";
        List<RedeInterface> interfacesRede = new ArrayList<>();
        for (RedeInterface o : looca.getRede().getGrupoDeInterfaces().getInterfaces()) {
            if (o.getNome().equalsIgnoreCase("eth0") || o.getNome().equalsIgnoreCase("wlp3s0")) {
                mac = o.getEnderecoMac();
            }
        }
        looca.getRede().getGrupoDeInterfaces().getInterfaces();
        return mac;
    }

    public static boolean maquinaJaRegistrada() {
        boolean maquinaRegistrada;
        List<Maquina> maquinas = con.query("""
        SELECT macAddress FROM maquina WHERE macAddress = ? ;
        """, new BeanPropertyRowMapper<>(Maquina.class), macAddress);

        maquinaRegistrada = !maquinas.isEmpty();
        return maquinaRegistrada;
    }

    public static void registrarMaquina(int fkAgencia, int fkTipoMaquina, String nome) {
        System.out.printf("%s %s %s %s\n", fkAgencia, fkTipoMaquina, macAddress, nome);
        con.update("INSERT INTO maquina (fkAgencia, fkTipoMaquina, macAddress, nome, localizacao, so) VALUES (?,?,?,?, '09937-123', 'Ubuntu 22.04')",
                fkAgencia, fkTipoMaquina, macAddress, nome);
    }

    public static Maquina getMaquina() {
        List<Maquina> maquinas = con.query("SELECT * FROM maquina WHERE macAddress = ?",
                new BeanPropertyRowMapper<>(Maquina.class), macAddress);
        return maquinas.isEmpty() ? null : maquinas.get(0);
    }
}
