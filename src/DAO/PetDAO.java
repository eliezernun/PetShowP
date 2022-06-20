package DAO;
import DB.DBC;
import DTO.PetDTO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarPET(PetDTO objPet) {
        String sql = "insert into Pets(dono_id, nome, aniversario, comentario, tamanho, inativo) values(?,?,?,?,?,?)";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, 2);
            pstm.setString(2, objPet.getNome_pet());
            pstm.setString(3, objPet.getAniversario_pet());
            pstm.setString(4, objPet.getComentario_pet());
            pstm.setString(5, objPet.getTamanho_pet());
            pstm.setBoolean(6, false);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public List <PetDTO> recuperarPets(int id) {
        String sql = "SELECT * FROM Pets WHERE dono_id = ?";
        conn = new DBC().conectarDB();
        List <PetDTO> pets = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                PetDTO pet = new PetDTO();
                pet.setID(rs.getInt("id"));
                pet.setNome_pet(rs.getString("nome"));
                pet.setAniversario_pet(rs.getString("aniversario"));
                pet.setComentario_pet(rs.getString("comentario"));
                pet.setTamanho_pet(rs.getString("tamanho"));
                pet.setInativo_pet(rs.getBoolean("inativo"));
                pets.add(pet);
            }

            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        return pets;
    }
}
