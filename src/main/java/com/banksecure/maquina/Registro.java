package com.banksecure.maquina;

import com.banksecure.database.Conexao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
public class Registro {
    private static Conexao connection = new Conexao();
    private static JdbcTemplate con = connection.getConexaoDoBanco();

    private static Integer getIdPorNomeMaquina(String nomeMaquina){
        Integer id = null;
        List<Componente> componentes = con.query("SELECT idComponente from componente where nome = ?",
                new BeanPropertyRowMapper<>(Componente.class),
                nomeMaquina);
        id = componentes.get(0).getIdComponente();
        return id;
    }
    public static void inserirRegistro(double valor, String nomeMaquina){
        int idComponente = getIdPorNomeMaquina(nomeMaquina);
        int idMaquina = MaquinaDAO.getMaquina().getIdMaquina();
        con.update("INSERT INTO registros (fkMaquina, fkComponente, valor, dataHora) VALUES (?, ?, ?, NOW())",
                idMaquina, idComponente, valor);

    }

    public static void main(String[] args) {
        inserirRegistro(22.0, "CPU");
    }
}
