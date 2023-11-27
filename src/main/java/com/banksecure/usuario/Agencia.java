package com.banksecure.usuario;

public class Agencia {
    private int idAgencia;
    private String cnpjAgencia;
    private String apelido;
    private String logradouro;
    private int numero;
    private String CEP;
    private String telefoneAgencia;
    private int fkEmpresa;

    public Agencia(String cnpjAgencia, String apelido, String logradouro, int numero, String CEP, String telefoneAgencia, int fkEmpresa) {
        this.cnpjAgencia = cnpjAgencia;
        this.apelido = apelido;
        this.logradouro = logradouro;
        this.numero = numero;
        this.CEP = CEP;
        this.telefoneAgencia = telefoneAgencia;
        this.fkEmpresa = fkEmpresa;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getCnpjAgencia() {
        return cnpjAgencia;
    }

    public void setCnpjAgencia(String cnpjAgencia) {
        this.cnpjAgencia = cnpjAgencia;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getTelefoneAgencia() {
        return telefoneAgencia;
    }

    public void setTelefoneAgencia(String telefoneAgencia) {
        this.telefoneAgencia = telefoneAgencia;
    }

    public int getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(int fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "idAgencia=" + idAgencia +
                ", cnpjAgencia='" + cnpjAgencia + '\'' +
                ", apelido='" + apelido + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", CEP='" + CEP + '\'' +
                ", telefoneAgencia='" + telefoneAgencia + '\'' +
                ", fkEmpresa=" + fkEmpresa +
                '}';
    }
}
