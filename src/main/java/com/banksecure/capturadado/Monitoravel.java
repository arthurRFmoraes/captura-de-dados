package com.banksecure.capturadado;

import com.github.britooo.looca.api.core.Looca;

import java.text.DecimalFormat;

public interface Monitoravel {
    DecimalFormat df = new DecimalFormat("0.00");
    static Looca looca = new Looca();

    static double capturarDados(){
        return 0.0;
    };
    static String getNome() {return "";}


}
