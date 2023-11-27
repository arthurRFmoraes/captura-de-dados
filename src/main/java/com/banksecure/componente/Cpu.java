package com.banksecure.componente;

import com.banksecure.maquina.CapturaDados;

public class Cpu extends CapturaDados {



    public static double capturarDados() {
        return getLooca().getProcessador().getUso();
    }
    public static String getNome(){
        return "CPU";
    }

}
