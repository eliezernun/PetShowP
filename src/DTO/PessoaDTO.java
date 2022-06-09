package DTO;

public class PessoaDTO {
    private String nome_pessoa, telefone_pessoa, logradouro_pessoa, cpf_pessoa;
    private boolean pessoa_funcionario = false;

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getTelefone_pessoa() {
        return telefone_pessoa;
    }

    public void setTelefone_pessoa(String telefone_pessoa) {
        this.telefone_pessoa = telefone_pessoa;
    }

    public String getLogradouro_pessoa() {
        return logradouro_pessoa;
    }

    public void setLogradouro_pessoa(String logradouro_pessoa) {
        this.logradouro_pessoa = logradouro_pessoa;
    }

    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    public void setCpf_pessoa(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }

    public boolean isPessoa_funcionario() {
        return pessoa_funcionario;
    }

    public void setPessoa_funcionario(boolean pessoa_funcionario) {
        this.pessoa_funcionario = pessoa_funcionario;
    }
}
