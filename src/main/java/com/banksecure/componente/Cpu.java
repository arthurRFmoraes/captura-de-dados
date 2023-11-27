package com.banksecure.componente;



import com.banksecure.maquina.CapturaDados;

public class Cpu extends CapturaDados {


    public static double capturarDados() {
        return Double.parseDouble(df.format(getLooca().getProcessador().getUso()).replace(",", "."));
    }
    public static String getNome(){
        return "CPU";
    }

}
