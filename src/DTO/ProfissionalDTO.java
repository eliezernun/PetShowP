package DTO;

public class ProfissionalDTO {
    double salario;
    boolean acesso_sistema;
    int  id, id_pessoa, id_funcao;
    String numero_ctps, numero_certidao, numero_rg, numero_reservista, numero_pis, numero_crmv;
    String escolaridad, data_admi="1900-01-01", data_des = "1900-01-01";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNumero_ctps() {
        return numero_ctps;
    }

    public void setNumero_ctps(String numero_ctps) {
        this.numero_ctps = String.valueOf(numero_ctps);
    }

    public String getNumero_certidao() {
        return numero_certidao;
    }

    public void setNumero_certidao(String numero_certidao) {
        this.numero_certidao = String.valueOf(numero_certidao);
    }

    public String getNumero_rg() {
        return numero_rg;
    }

    public void setNumero_rg(String numero_rg) {
        this.numero_rg = String.valueOf(numero_rg);
    }

    public String getNumero_reservista() {
        return numero_reservista;
    }

    public void setNumero_reservista(String numero_reservista) {
        this.numero_reservista = String.valueOf(numero_reservista);
    }

    public String getNumero_pis() {
        return numero_pis;
    }

    public void setNumero_pis(String numero_pis) {
        this.numero_pis = String.valueOf(numero_pis);
    }

    public String getNumero_crmv() {
        return numero_crmv;
    }

    public void setNumero_crmv(String numero_crmv) {
        this.numero_crmv = String.valueOf(numero_crmv);
    }

    public String getData_admi() {
        return data_admi;
    }

    public void setData_admi(String data_admi) {
        this.data_admi = "1900-01-01";
    }

    public String getData_des() {
        return data_des;
    }

    public void setData_des(String data_des) {
        this.data_des = "1900-01-01";
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
    public void limparProfissional(){
        this.id = 0;
        this.id_pessoa = 0;
        this.id_funcao = 0;
        this.numero_ctps = "";
        this.numero_certidao = "";
        this.numero_rg = "";
        this.numero_reservista = "";
        this.numero_pis = "";
        this.numero_crmv = "";

    }
}
