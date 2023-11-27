package com.banksecure.maquina;

import com.github.britooo.looca.api.core.Looca;

import java.text.DecimalFormat;

public abstract class CapturaDados {
    private static Looca looca = new Looca();
    public static final DecimalFormat df = new DecimalFormat("0.00");

    public static double capturarDados(){
        return 0.0;
    };

    public static String getNome() {
        return "";
    }

    public static Looca getLooca() {
        return looca;
    }

}
