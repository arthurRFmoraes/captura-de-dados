package com.banksecure;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;

import com.banksecure.maquina.MaquinaDAO;
import com.banksecure.usuario.Agencia;
import com.banksecure.usuario.AgenciaDAO;
import com.banksecure.usuario.Usuario;
import com.banksecure.usuario.UsuarioDAO;
import com.github.britooo.looca.api.core.Looca;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Scanner stop = new Scanner(System.in);
        Scanner inputTexto = new Scanner(System.in);
        Scanner inputNumero = new Scanner(System.in);

        Usuario usuario;
        do{
            System.out.println("Inicializando aplicação...");
            System.out.println("Digite seu email: ");
            String email = inputTexto.nextLine();

            System.out.println("Digite sua senha: ");
            String senha = inputTexto.nextLine();
            usuario = UsuarioDAO.login(new Usuario(email, senha));
        }while(Objects.isNull(usuario));
        if(MaquinaDAO.maquinaJaRegistrada(usuario)){
            System.out.println("Iniciando a captura de dados");
            CapturarDado c1 = new CapturarDado(1000, 5000);
            timer.schedule(c1, c1.getDelay(), c1.getPeriod());
            System.out.println("Digite qualquer coisa para parar");
            stop.nextLine();
        }else{
            boolean agenciaForaDoIndex;
            Agencia agencia;
            int tipoMaquina;
            
            do{
                List<Agencia> agencias = AgenciaDAO.getAgencias(usuario);
                if(agencias.isEmpty()){
                    System.out.println("Nenhuma agência vinculada a este funcionário.");
                    System.out.println("Programa encerrando...");
                    break;
                }else{
                    int indexAgenciaEscolhido;
                    for(int i = 0; i < agencias.size(); i++){
                        System.out.println(String.format("%d - %s", i + 1, agencias.get(i).getApelido()));
                    }
                    System.out.println("Digite o numero da agência correspondente: ");
                    indexAgenciaEscolhido = inputNumero.nextInt();
                    if(indexAgenciaEscolhido >= 0 && indexAgenciaEscolhido < agencias.size()){
                        agencia = agencias.get(indexAgenciaEscolhido);
                        agenciaForaDoIndex = false;
                    }else{
                        agenciaForaDoIndex = true;
                    }
                }
            }while(agenciaForaDoIndex);
            System.out.println("");
        }

        timer.cancel();
        stop.close();
        inputTexto.close();
        inputNumero.close();
    }
}