package com.banksecure.dao;

import com.banksecure.dao.MaquinaDAO;
import com.banksecure.database.ConexaoMysql;
import com.banksecure.model.Componente;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
public class RegistroDAO {
    private static ConexaoMysql connection = new ConexaoMysql();
    private static JdbcTemplate con = connection.getConexaoDoBanco();

    private static Integer getIdPorNomeComponente(String nomeComponente){
        Integer id = null;
        List<Componente> componentes = con.query("SELECT idComponente from componente where nome = ?",
                new BeanPropertyRowMapper<>(Componente.class),
                nomeComponente);
        id = componentes.get(0).getIdComponente();
        return id;
    }
    public static void inserirRegistro(double valor, String nomeMaquina){
        int idComponente = getIdPorNomeComponente(nomeMaquina);
        int idMaquina = MaquinaDAO.getMaquina().getIdMaquina();
        con.update("INSERT INTO registros (fkMaquina, fkComponente, valor, dataHora) VALUES (?, ?, ?, NOW())",
                idMaquina, idComponente, valor);

    }

    public static void main(String[] args) {
        inserirRegistro(22.0, "CPU");
    }
}
