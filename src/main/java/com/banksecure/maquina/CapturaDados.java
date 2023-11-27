package com.banksecure.maquina;

import com.github.britooo.looca.api.core.Looca;

public abstract class CapturaDados {
    private static Looca looca = new Looca();

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
