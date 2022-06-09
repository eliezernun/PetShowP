package DTO;

public class ProfissionalDTO {
    int id_pessoa, id_funcao;
    double salario;
    boolean acesso_sistema;

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
