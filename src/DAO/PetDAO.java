package DAO;
import DB.DBC;
import DTO.PetDTO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PetDAO {
    Connection conn;
    PreparedStatement pstm;
    public void cadastrarPET(PetDTO objPet){
        String sql = "insert into Pets(dono_id, nome, aniversario, comentario, tamanho, inativo) values(?,?,?,?,?,?)";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,2);
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

}
