package DTO;

public class TrocaSenhaDTO {
    String Senha;
    String Senha_Repetir;

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getSenha_Repetir() {
        return Senha_Repetir;
    }

    public void setSenha_Repetir(String senha_Repetir) {
        Senha_Repetir = senha_Repetir;
    }

    public boolean SenhaCompare(){
        if(this.Senha.equals(this.Senha_Repetir)){
            return true;
        }
        return  false;
    }
}
