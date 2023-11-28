package com.banksecure.componente;



import com.banksecure.capturadado.Monitoravel;
import com.github.britooo.looca.api.core.Looca;

import java.text.DecimalFormat;

public class Cpu implements Monitoravel {

    public static double capturarDados() {
        return Double.parseDouble(df.format(looca.getProcessador().getUso()).replace(",", "."));
    }
    public static String getNome(){
        return "CPU";
    }

}
