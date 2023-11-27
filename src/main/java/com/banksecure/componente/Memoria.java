package com.banksecure.componente;

import com.banksecure.maquina.CapturaDados;

public class Memoria extends CapturaDados {
    public static double capturarDados() {
        return (Math.ceil((double) getLooca().getMemoria().getEmUso()) /
                ((double) getLooca().getMemoria().getTotal())) * 100;
    }

    public static void main(String[] args) {
        System.out.println(capturarDados());
    }
    public static String getNome(){
        return "Memória";
    }
}
