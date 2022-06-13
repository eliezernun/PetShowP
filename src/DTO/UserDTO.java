package DTO;

public class UserDTO {
    String usuario, senha;
    int modulo_pessoa, modulo_agenda, modulo_caixa, modulo_cfg, modulo_pessoa_funionario;
    int modulo_pessoa_alterar_usuario, modulo_pessoa_admin, profissional_id, modulo_relatorios;
    boolean inativo, trocarSenha;

    public boolean isTrocarSenha() {
        return trocarSenha;
    }

    public void setTrocarSenha(boolean trocarSenha) {
        this.trocarSenha = trocarSenha;
    }

    public int getModulo_relatorios() {
        return modulo_relatorios;
    }

    public void setModulo_relatorios(int modulo_relatorios) {
        this.modulo_relatorios = modulo_relatorios;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getModulo_pessoa() {
        return modulo_pessoa;
    }

    public void setModulo_pessoa(int modulo_pessoa) {
        this.modulo_pessoa = modulo_pessoa;
    }

    public int getModulo_agenda() {
        return modulo_agenda;
    }

    public void setModulo_agenda(int modulo_agenda) {
        this.modulo_agenda = modulo_agenda;
    }

    public int getModulo_caixa() {
        return modulo_caixa;
    }

    public void setModulo_caixa(int modulo_caixa) {
        this.modulo_caixa = modulo_caixa;
    }

    public int getModulo_cfg() {
        return modulo_cfg;
    }

    public void setModulo_cfg(int modulo_cfg) {
        this.modulo_cfg = modulo_cfg;
    }

    public int getModulo_pessoa_funionario() {
        return modulo_pessoa_funionario;
    }

    public void setModulo_pessoa_funionario(int modulo_pessoa_funionario) {
        this.modulo_pessoa_funionario = modulo_pessoa_funionario;
    }

    public int getModulo_pessoa_alterar_usuario() {
        return modulo_pessoa_alterar_usuario;
    }

    public void setModulo_pessoa_alterar_usuario(int modulo_pessoa_alterar_usuario) {
        this.modulo_pessoa_alterar_usuario = modulo_pessoa_alterar_usuario;
    }

    public int getModulo_pessoa_admin() {
        return modulo_pessoa_admin;
    }

    public void setModulo_pessoa_admin(int modulo_pessoa_admin) {
        this.modulo_pessoa_admin = modulo_pessoa_admin;
    }

    public int getProfissional_id() {
        return profissional_id;
    }

    public void setProfissional_id(int profissional_id) {
        this.profissional_id = profissional_id;
    }
}
