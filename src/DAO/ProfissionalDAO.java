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
        String sql = "insert into Profissional(id_pessoa, salario, funcao_id, acesso_sistema, numero_ctps," +
                "numero_certidao, numero_rg, numero_reservista, numero_pis, data_admi, data_des, numero_crmv) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objProfissional.getId_pessoa());
            pstm.setDouble(2, objProfissional.getSalario());
            pstm.setInt(3, objProfissional.getId_funcao());
            pstm.setBoolean(4, objProfissional.isAcesso_sistema());
            pstm.setString(5, objProfissional.getNumero_ctps());
            pstm.setString(6, objProfissional.getNumero_certidao());
            pstm.setString(7, objProfissional.getNumero_rg());
            pstm.setString(8, objProfissional.getNumero_reservista());
            pstm.setString(9, objProfissional.getNumero_pis());
            pstm.setString(10, objProfissional.getData_admi());
            pstm.setString(11, objProfissional.getData_des());
            pstm.setString(12, objProfissional.getNumero_crmv());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    public ProfissionalDTO getDadosProfissional(int id){
        ProfissionalDTO ObjectProfissional = new ProfissionalDTO();
        String sql = "SELECT * from Profissional WHERE id_pessoa = ?";
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
               ObjectProfissional.setNumero_ctps(rs.getString("numero_ctps"));
               ObjectProfissional.setNumero_certidao(rs.getString("numero_certidao"));
               ObjectProfissional.setNumero_rg(rs.getString("numero_rg"));
               ObjectProfissional.setNumero_reservista(rs.getString("numero_reservista"));
               ObjectProfissional.setNumero_pis(rs.getString("numero_pis"));
               String admi = rs.getString("data_admi");
               if(admi == null){
                   admi = "19001201";
               }
               ObjectProfissional.setData_admi(admi);
               String desliga = rs.getString("data_des");
               if(desliga == null){
                   desliga = "19001201";
               }
               ObjectProfissional.setData_des(desliga);
               ObjectProfissional.setNumero_crmv(rs.getString("numero_crmv"));
           }

            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ObjectProfissional;
    }
    public void updateProfissional(ProfissionalDTO objProfissional){
        String sql = "UPDATE Profissional SET " +
                "salario = ?, " +
                "funcao_id = ?, " +
                "acesso_sistema =? , " +
                "numero_ctps = ?, " +
                "numero_certidao = ?, " +
                "numero_rg = ?, " +
                "numero_reservista = ?, " +
                "numero_pis = ?, " +
                "data_admi = ?, " +
                "data_des = ?, " +
                "numero_crmv =? " +
                "WHERE id_pessoa = ?";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);

            pstm.setDouble(1, objProfissional.getSalario());
            pstm.setInt(2, objProfissional.getId_funcao());
            pstm.setBoolean(3, objProfissional.isAcesso_sistema());
            pstm.setString(4, objProfissional.getNumero_ctps());
            pstm.setString(5, objProfissional.getNumero_certidao());
            pstm.setString(6, objProfissional.getNumero_rg());
            pstm.setString(7, objProfissional.getNumero_reservista());
            pstm.setString(8, objProfissional.getNumero_pis());
            pstm.setString(9, objProfissional.getData_admi());
            pstm.setString(10, objProfissional.getData_des());
            pstm.setString(11, objProfissional.getNumero_crmv());
            pstm.setInt(12, objProfissional.getId_pessoa());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
