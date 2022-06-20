package DTO;

public class PetDTO {
    String nome_pet, aniversario_pet, comentario_pet, tamanho_pet;
    boolean inativo_pet;
    int id = 0;

    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }


    public String getNome_pet() {
        return nome_pet;
    }

    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public String getAniversario_pet() {
        return aniversario_pet;
    }

    public void setAniversario_pet(String aniversario_pet) {
        this.aniversario_pet = aniversario_pet;
    }

    public String getComentario_pet() {
        return comentario_pet;
    }

    public void setComentario_pet(String comentario_pet) {
        this.comentario_pet = comentario_pet;
    }

    public String getTamanho_pet() {
        return tamanho_pet;
    }

    public void setTamanho_pet(String tamanho_pet) {
        this.tamanho_pet = tamanho_pet;
    }

    public boolean isInativo_pet() {
        return inativo_pet;
    }

    public void setInativo_pet(boolean inativo_pet) {
        this.inativo_pet = inativo_pet;
    }
}
