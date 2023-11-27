package com.banksecure.componente;

import com.banksecure.maquina.CapturaDados;

public class Disco extends CapturaDados {


    public static double capturarDados() {

        return 100.0 - ((double)getLooca().getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / getLooca().getGrupoDeDiscos().getVolumes().get(0).getTotal()) * 100;
    }
    public static String getNome(){
        return "Disco";
    }
}
