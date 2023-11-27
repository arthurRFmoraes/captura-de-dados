package com.banksecure.maquina;

public class Maquina {
    private int idMaquina;
    private int fkAgencia;
    private int fkTipoMaquina;
    private String macAddress;
    private String localizacao;
    private String nome;

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public int getFkAgencia() {
        return fkAgencia;
    }

    public void setFkAgencia(int fkAgencia) {
        this.fkAgencia = fkAgencia;
    }

    public int getFkTipoMaquina() {
        return fkTipoMaquina;
    }

    public void setFkTipoMaquina(int fkTipoMaquina) {
        this.fkTipoMaquina = fkTipoMaquina;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
