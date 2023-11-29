package com.banksecure.dao;

import com.banksecure.database.ConexaoSqlServer;
import com.banksecure.model.Componente;
import com.banksecure.model.Maquina;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RegistroSqlServerDAO {
    private static ConexaoSqlServer connection = new ConexaoSqlServer();
    private static JdbcTemplate con = connection.getConexaoDoBanco();

    private static Integer getIdPorNomeComponente(String nomeComponente) {
        Integer id = null;
        List<Componente> componentes = con.query("SELECT idComponente FROM componente WHERE nome = ?",
                new BeanPropertyRowMapper<>(Componente.class),
                nomeComponente);
        if (!componentes.isEmpty()) {
            id = componentes.get(0).getIdComponente();
        }
        return id;
    }

    public static void inserirRegistro(double valor, String nomeMaquina) {
        Integer idComponente = getIdPorNomeComponente(nomeMaquina);
        Maquina maquina = MaquinaSqlServerDAO.getMaquina();

        if (idComponente != null && maquina != null) {
            con.update("INSERT INTO registros (fkMaquina, fkComponente, valor, dataHora) VALUES (?, ?, ?, GETDATE())",
                    maquina.getIdMaquina(), idComponente, valor);
        }
    }

}
