package com.banksecure.capturadado;

import com.banksecure.helpdesk.AbrirChamado;
import com.banksecure.dao.MaquinaDAO;
import com.banksecure.dao.RegistroDAO;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ChamarMetodoComponente {
    public static void executarClasses(String nomePacote) {
        String caminhoPacote = nomePacote.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL pacoteURL = classLoader.getResource(caminhoPacote);

        if (pacoteURL != null) {
            File pacoteDiretorio = new File(Objects.requireNonNull(pacoteURL.getFile()));
            File[] arquivos = pacoteDiretorio.listFiles();
            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isFile() && arquivo.getName().endsWith(".class")) {
                        String nomeClasse = arquivo.getName().substring(0, arquivo.getName().length() - 6);
                        String caminhoPacoteClasse = nomePacote + '.' + nomeClasse;
                        try {
                            Class<?> classe = Class.forName(caminhoPacoteClasse);

                            Object instancia = classe.newInstance();

                            Method metodoCaptura = classe.getMethod("capturarDados");
                            Method metodoGetNome = classe.getMethod("getNome");
                            TimeUnit.MILLISECONDS.sleep(500);
                            try {
                                double valor = (double) metodoCaptura.invoke(instancia);
                                String nomeComponente = (String) metodoGetNome.invoke(instancia);
                                RegistroDAO.inserirRegistro(valor,nomeComponente);
                                if(valor >= 60.0 && valor < 75.0){
                                    AbrirChamado.AbrirChamado(MaquinaDAO.getMaquina().getNome(), nomeComponente, valor, 3);
                                }else if (valor >= 75.0 && valor < 90.0){
                                    AbrirChamado.AbrirChamado(MaquinaDAO.getMaquina().getNome(), nomeComponente, valor, 2);

                                }else if(valor >= 90.0){
                                    AbrirChamado.AbrirChamado(MaquinaDAO.getMaquina().getNome(), nomeComponente, valor, 1);
                                }
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        } else {
            System.out.println("Pacote não encontrado: " + nomePacote);
        }
    }

}
