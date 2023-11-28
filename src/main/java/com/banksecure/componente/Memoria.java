package com.banksecure.componente;

import com.banksecure.capturadado.Monitoravel;
import com.github.britooo.looca.api.core.Looca;

import java.text.DecimalFormat;

public class Memoria implements Monitoravel {
    
    public static double capturarDados() {
        return Double.parseDouble(df.format((((double) looca.getMemoria().getEmUso()) /
                        ((double) looca.getMemoria().getTotal())) * 100)
                .replace(",", "."));
    }

    public static void main(String[] args) {
        System.out.println(capturarDados());
    }
    public static String getNome(){
        return "Memória";
    }
}
