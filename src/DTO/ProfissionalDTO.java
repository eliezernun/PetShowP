package DTO;

import java.text.DateFormat;

public class ProfissionalDTO {
    int id, id_pessoa, id_funcao;
    double salario;
    boolean acesso_sistema;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int numero_ctps, numero_certidao, numero_rg, numero_reservista, numero_pis, numero_crmv;
    String escolaridad, data_admi, data_des;

    public int getNumero_ctps() {
        return numero_ctps;
    }

    public void setNumero_ctps(int numero_ctps) {
        this.numero_ctps = numero_ctps;
    }

    public int getNumero_certidao() {
        return numero_certidao;
    }

    public void setNumero_certidao(int numero_certidao) {
        this.numero_certidao = numero_certidao;
    }

    public int getNumero_rg() {
        return numero_rg;
    }

    public void setNumero_rg(int numero_rg) {
        this.numero_rg = numero_rg;
    }

    public int getNumero_reservista() {
        return numero_reservista;
    }

    public void setNumero_reservista(int numero_reservista) {
        this.numero_reservista = numero_reservista;
    }

    public int getNumero_pis() {
        return numero_pis;
    }

    public void setNumero_pis(int numero_pis) {
        this.numero_pis = numero_pis;
    }

    public int getNumero_crmv() {
        return numero_crmv;
    }

    public void setNumero_crmv(int numero_crmv) {
        this.numero_crmv = numero_crmv;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getData_admi() {
        return data_admi;
    }

    public void setData_admi(String data_admi) {
        this.data_admi = data_admi;
    }

    public String getData_des() {
        return data_des;
    }

    public void setData_des(String data_des) {
        this.data_des = data_des;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_funcao() {
        return id_funcao;
    }

    public void setId_funcao(int id_funcao) {
        this.id_funcao = id_funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isAcesso_sistema() {
        return acesso_sistema;
    }

    public void setAcesso_sistema(boolean acesso_sistema) {
        this.acesso_sistema = acesso_sistema;
    }
}
