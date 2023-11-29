package com.banksecure;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;

import com.banksecure.capturadado.CapturarDado;
import com.banksecure.dao.MaquinaMysqlDAO;
import com.banksecure.dao.MaquinaSqlServerDAO;
import com.banksecure.model.Agencia;
import com.banksecure.dao.AgenciaMysqlDAO;

import com.banksecure.model.Usuario;
import com.banksecure.dao.UsuarioMysqlDAO;

public class Main {
    public static void main(String[] args) {

        Timer timer = new Timer();
        Scanner stop = new Scanner(System.in);
        Scanner inputTexto = new Scanner(System.in);
        Scanner inputNumero = new Scanner(System.in);



        if(MaquinaMysqlDAO.maquinaJaRegistrada()){

            System.out.println("Iniciando a captura de dados");
            CapturarDado c1 = new CapturarDado(1000, 6000);
            timer.schedule(c1, c1.getDelay(), c1.getPeriod());
            System.out.println("Digite qualquer coisa para parar");
            stop.nextLine();

        }else{

            Usuario usuario;

            System.out.println("Inicializando aplicação...");

            do{
                System.out.println("Máquina não registrada.\nInicializando registro.");

                System.out.println("Digite seu email: ");
                String email = inputTexto.nextLine();
                System.out.println("Digite sua senha: ");
                String senha = inputTexto.nextLine();
                usuario = UsuarioMysqlDAO.login(new Usuario(email, senha));

            }while(Objects.isNull(usuario));
            boolean agenciaForaDoIndex;
            Agencia agencia = new Agencia();
            int indexAgenciaEscolhido;
            int tipoMaquina;
            String nomeMaquina;

            do{

                List<Agencia> agencias = AgenciaMysqlDAO.getAgencias(usuario);
                if(agencias.isEmpty()){
                    System.out.println("Nenhuma agência vinculada a este funcionário.");
                    System.out.println("Programa encerrando...");
                    break;

                }else{

                    for(int i = 0; i < agencias.size(); i++){
                        System.out.println(String.format("%d - %s", i + 1, agencias.get(i).getApelido()));
                    }

                    System.out.println("Digite o numero da agência correspondente: ");
                    indexAgenciaEscolhido = inputNumero.nextInt();
                    indexAgenciaEscolhido -= 1;

                    if(indexAgenciaEscolhido >= 0 && indexAgenciaEscolhido < agencias.size()){
                        agencia = agencias.get(indexAgenciaEscolhido);
                        agenciaForaDoIndex = false;

                    }else{
                        agenciaForaDoIndex = true;
                    }
                }

            }while(agenciaForaDoIndex);

            do{
                System.out.println("1 - Servidor\n2 - Caixa eletrônico");
                tipoMaquina = inputNumero.nextInt();

            }while(tipoMaquina < 1 || tipoMaquina > 2);

            System.out.println("Digite o nome da máquina: ");
            nomeMaquina = inputTexto.nextLine();

            MaquinaMysqlDAO.registrarMaquina(agencia.getIdAgencia(), tipoMaquina, nomeMaquina);
            MaquinaSqlServerDAO.registrarMaquina(agencia.getIdAgencia(), tipoMaquina, nomeMaquina);
            System.out.println("Máquina registrada com sucesso!");

            System.out.println("Iniciando a captura de dados");
            CapturarDado c1 = new CapturarDado(1000, 5000);
            timer.schedule(c1, c1.getDelay(), c1.getPeriod());
            System.out.println("Digite qualquer coisa para parar");
            stop.nextLine();

        }

        timer.cancel();
        System.out.println("Programa encerrado.");
        stop.close();
        inputTexto.close();
        inputNumero.close();
    }
}