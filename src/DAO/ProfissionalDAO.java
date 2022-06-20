package DAO;

import DB.DBC;
import DTO.ProfissionalDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfissionalDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    public void cadastrarProfissional(ProfissionalDTO objProfissional){
        String sql = "insert into Profissioal(id_pessoa, salario, funcao_id, acesso_sistema, numero_ctps" +
                "numero_certidao, escolaridade, numero_rg, numero_reservista, numero_pis, data_admi, data_des, numero_crmv,) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objProfissional.getId_pessoa());
            pstm.setDouble(2, objProfissional.getSalario());
            pstm.setInt(3, objProfissional.getId_funcao());
            pstm.setBoolean(4, objProfissional.isAcesso_sistema());
            pstm.setInt(5, objProfissional.getNumero_ctps());
            pstm.setInt(6, objProfissional.getNumero_certidao());
            pstm.setString(7, objProfissional.getEscolaridad());
            pstm.setInt(8, objProfissional.getNumero_rg());
            pstm.setInt(9, objProfissional.getNumero_reservista());
            pstm.setInt(10, objProfissional.getNumero_pis());
            pstm.setString(11, objProfissional.getData_admi());
            pstm.setString(12, objProfissional.getData_des());
            pstm.setInt(13, objProfissional.getNumero_crmv());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    public ProfissionalDTO getDadosProfissional(int id){
        ProfissionalDTO ObjectProfissional = new ProfissionalDTO();
        String sql = "SELECT from Profissional where id_pessoa = ?";
        conn = new DBC().conectarDB();
        try{
           pstm = conn.prepareStatement(sql);
           pstm.setInt(1, id);
           rs = pstm.executeQuery();
           while(rs.next()){
               ObjectProfissional.setId(rs.getInt("id"));
               ObjectProfissional.setId_pessoa(rs.getInt("id_pessoa"));
               ObjectProfissional.setSalario(rs.getDouble("salario"));
               ObjectProfissional.setId_funcao(rs.getInt("funcao_id"));
               ObjectProfissional.setAcesso_sistema(rs.getBoolean("acesso_sistema"));
               ObjectProfissional.setNumero_ctps(rs.getInt("numero_ctps"));
               ObjectProfissional.setNumero_certidao(rs.getInt("numero_certidao"));
               ObjectProfissional.setEscolaridad(rs.getString("escolaridade"));
               ObjectProfissional.setNumero_rg(rs.getInt("numero_rg"));
               ObjectProfissional.setNumero_reservista(rs.getInt("numero_reservista"));
               ObjectProfissional.setNumero_pis(rs.getInt("numero_pis"));
               ObjectProfissional.setData_admi(rs.getString("data_admi"));
               ObjectProfissional.setData_des(rs.getString("data_des"));
               ObjectProfissional.setNumero_crmv(rs.getInt("numero_crmv"));
           }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ObjectProfissional;
    }
    public void updateProfissional(ProfissionalDTO objProfissional){
        String sql = "UPDATE into Profissioal  salario = ?, funcao_id = ?, acesso_sistema =? , numero_ctps = ?" +
                "numero_certidao = ?, escolaridade = ?, numero_rg = ?, numero_reservista = ?, numero_pis = ?, data_admi = ?, data_des = ?, numero_crmv =?" +
                "WHERE id_pessoa = ?";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);

            pstm.setDouble(1, objProfissional.getSalario());
            pstm.setInt(2, objProfissional.getId_funcao());
            pstm.setBoolean(3, objProfissional.isAcesso_sistema());
            pstm.setInt(4, objProfissional.getNumero_ctps());
            pstm.setInt(5, objProfissional.getNumero_certidao());
            pstm.setString(6, objProfissional.getEscolaridad());
            pstm.setInt(7, objProfissional.getNumero_rg());
            pstm.setInt(8, objProfissional.getNumero_reservista());
            pstm.setInt(9, objProfissional.getNumero_pis());
            pstm.setString(10, objProfissional.getData_admi());
            pstm.setString(11, objProfissional.getData_des());
            pstm.setInt(12, objProfissional.getNumero_crmv());
            pstm.setInt(13, objProfissional.getId_pessoa());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
