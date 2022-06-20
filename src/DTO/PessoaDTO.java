package DTO;

public class PessoaDTO {
    private String nome_pessoa, telefone_pessoa, logradouro_pessoa, cpf_pessoa, ddd_pessoa,  pessoa_bairro;
    private String pessoa_endereco_numero, pessoa_endereco_bairro, pessoa_endereco_cep;
    private boolean pessoa_funcionario, pessoa_inativa, whatsapp_pessoa;
    int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWhatsapp_pessoa() {
        return whatsapp_pessoa;
    }

    public void setWhatsapp_pessoa(boolean whatsapp_pessoa) {
        this.whatsapp_pessoa = whatsapp_pessoa;
    }

    public String getDdd_pessoa() {
        return ddd_pessoa;
    }

    public void setDdd_pessoa(String ddd_pessoa) {
        this.ddd_pessoa = ddd_pessoa;
    }


    public String getPessoa_bairro() {
        return pessoa_bairro;
    }

    public void setPessoa_bairro(String pessoa_bairro) {
        this.pessoa_bairro = pessoa_bairro;
    }

    public String getPessoa_endereco_numero() {
        return pessoa_endereco_numero;
    }

    public void setPessoa_endereco_numero(String pessoa_endereco_numero) {
        this.pessoa_endereco_numero = pessoa_endereco_numero;
    }

    public String getPessoa_endereco_bairro() {
        return pessoa_endereco_bairro;
    }

    public void setPessoa_endereco_bairro(String pessoa_endereco_bairro) {
        this.pessoa_endereco_bairro = pessoa_endereco_bairro;
    }

    public String getPessoa_endereco_cep() {
        return pessoa_endereco_cep;
    }

    public void setPessoa_endereco_cep(String pessoa_endereco_cep) {
        this.pessoa_endereco_cep = pessoa_endereco_cep;
    }

    public boolean isPessoa_inativa() {
        return pessoa_inativa;
    }

    public void setPessoa_inativa(boolean pessoa_inativa) {
        this.pessoa_inativa = pessoa_inativa;
    }

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
    public void setPessoaLimpar(){
                this.id = 0;
                this.nome_pessoa = "";
                this.telefone_pessoa = "";
                this.logradouro_pessoa = "";
                this.cpf_pessoa = "";
                this.ddd_pessoa = "";
                this. pessoa_bairro = "";
                this. pessoa_endereco_numero = "";
                this.pessoa_endereco_bairro = "";
                this.pessoa_endereco_cep = "";
                this.pessoa_funcionario = false;
                this.pessoa_inativa = false;
                this.whatsapp_pessoa = false;
    }
}
