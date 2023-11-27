package com.banksecure;
import java.util.Scanner;
import java.util.Timer;

import com.github.britooo.looca.api.core.Looca;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Scanner in = new Scanner(System.in);

        CapturarDado c1 = new CapturarDado(1000, 5000);
        timer.schedule(c1, c1.getDelay(), c1.getPeriod());
        System.out.println("Digite qualquer coisa para parar");
        in.nextLine();
        timer.cancel();


    }
}