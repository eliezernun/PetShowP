package DAO;

import DB.DBC;
import DTO.ProfissionalDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfissionalDAO {
    Connection conn;
    PreparedStatement pstm;

    public void cadastrarProfissional(ProfissionalDTO objProfissioanal){
        String sql = "insert into Profissioal(id_pessoa, salario, funcao_id, acesso_sistema) values(?,?,?,?)";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,2);
            pstm.setInt(2, objProfissioanal.getId_pessoa());
            pstm.setDouble(3, objProfissioanal.getSalario());
            pstm.setInt(4, objProfissioanal.getId_funcao());
            pstm.setBoolean(5, objProfissioanal.isAcesso_sistema());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
