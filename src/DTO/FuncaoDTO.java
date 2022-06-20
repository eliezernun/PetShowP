package DTO;

public class FuncaoDTO {
    private int id = 0;
    private String descricao;
    private boolean inativo;

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void limparFuncao(){
        this.id = 0;
        this.descricao = "";
    }

}
