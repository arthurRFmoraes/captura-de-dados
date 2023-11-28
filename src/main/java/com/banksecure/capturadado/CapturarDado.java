package com.banksecure.capturadado;

import java.util.TimerTask;

public class CapturarDado extends TimerTask {
    private int delay;
    private int period;

    public CapturarDado(int delay, int period) {
        this.delay = delay;
        this.period = period;
    }
    public int getDelay() {
        return delay;
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public boolean cancel() {
        return super.cancel();
    }

    @Override
    public long scheduledExecutionTime() {
        return super.scheduledExecutionTime();
    }

    @Override
    public void run() {
        ChamarMetodoComponente.executarClasses("com.banksecure.componente");
    }
}
