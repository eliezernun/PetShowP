package DTO;

public class PetDTO {
    String nome_pet, aniversario_pet, comentario_pet;
    boolean inativo_pet;
    int id = 0;
    int id_dono = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dono() {
        return id_dono;
    }

    public void setId_dono(int id_dono) {
        this.id_dono = id_dono;
    }

    public void limpar(){
        this.nome_pet ="";
        this.aniversario_pet ="";
        this.comentario_pet = "";
        this.inativo_pet = false;
        this.id = 0;
        this.id_dono = 0;
    }

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

    public boolean isInativo_pet() {
        return inativo_pet;
    }

    public void setInativo_pet(boolean inativo_pet) {
        this.inativo_pet = inativo_pet;
    }
}
