package com.banksecure;

import com.github.britooo.looca.api.core.Looca;

public class TesteMacAddress {
    public static void main(String[] args) {
        Looca l = new Looca();
        System.out.println(l.getRede().getGrupoDeInterfaces().getInterfaces());
    }
}
