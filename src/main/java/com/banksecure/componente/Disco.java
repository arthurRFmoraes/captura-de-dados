package com.banksecure.componente;

import com.banksecure.capturadado.Monitoravel;
import com.github.britooo.looca.api.core.Looca;

import java.text.DecimalFormat;

public class Disco implements Monitoravel {
    
    public static double capturarDados() {

        return Double.parseDouble((df.format(100.0 - (double) looca.getGrupoDeDiscos()
                .getVolumes().get(0).getDisponivel() / looca.getGrupoDeDiscos().getVolumes()
                .get(0).getTotal() * 100).replace(",", ".") ));
    }
    public static String getNome(){
        return "Disco";
    }
}
