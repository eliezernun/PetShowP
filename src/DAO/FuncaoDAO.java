package DAO;

import DB.DBC;
import DTO.FuncaoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncaoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    public void setFuncion(FuncaoDTO funcao){
        String sql ="insert into Funcoes(descricao) values(?)";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcao.getDescricao());
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<FuncaoDTO> getFuncoes(){
        String sql = "Select * from Funcoes";
        conn = new DBC().conectarDB();
        List<FuncaoDTO> funcoes = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()){
                FuncaoDTO funcao = new FuncaoDTO();
                funcao.setId(rs.getInt("id"));
                funcao.setDescricao(rs.getString("descricao"));
                funcao.setInativo(rs.getBoolean("inativo"));
                funcoes.add(funcao);
            }
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcoes;
    }

    public void updateFuncao(FuncaoDTO funcao){
        String sql = "UPDATE Funcoes SET descricao = ?, inativo = ? WHERE id = ? ";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcao.getDescricao());
            pstm.setBoolean(2, funcao.isInativo());
            pstm.setInt(3, funcao.getId());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
