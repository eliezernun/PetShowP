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
        String sql = "insert into Pets(dono_id, nome, aniversario, comentario, inativo) values(?,?,?,?,?)";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objPet.getId_dono());
            pstm.setString(2, objPet.getNome_pet());
            pstm.setString(3, objPet.getAniversario_pet());
            pstm.setString(4, objPet.getComentario_pet());
            pstm.setBoolean(5, false);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public List <PetDTO> recuperarPets(int id) {
        String sql = "SELECT * FROM Pets WHERE dono_id = ? ORDER BY inativo ASC";
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
    public void updatePets(PetDTO objPet){
        String sql = "UPDATE Pets SET nome = ?, aniversario = ?, comentario = ?, inativo = ? WHERE id = ?";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objPet.getNome_pet().toUpperCase());
            pstm.setString(2, objPet.getAniversario_pet());
            pstm.setString(3, objPet.getComentario_pet());
            pstm.setBoolean(4, objPet.isInativo_pet());
            pstm.setInt(5, objPet.getID());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
