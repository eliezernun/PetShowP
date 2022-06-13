package DAO;

import DB.DBC;
import DTO.UserDTO;
import UTIL.PW_Encrypt;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    Connection conn;
    PreparedStatement pstm;

    public UserDTO getUserPropsFromDB(String user, String pw){
        String sql = "SELECT * FROM Usuarios_Sistema WHERE usuario LIKE ?";
        conn = new DBC().conectarDB();
        UserDTO userObject = new UserDTO();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user);
            ResultSet  rs = pstm.executeQuery();
            while(rs.next()){
                String pwa = rs.getString("senha");
                boolean inativo = rs.getBoolean("inativo");
                if(pwa.equals(pw) && !inativo){
                    System.out.println("OK");
                    userObject.setProfissional_id(rs.getInt("profissional_id"));
                    userObject.setUsuario(rs.getString("usuario"));
                    userObject.setSenha(rs.getString("senha"));
                    userObject.setModulo_agenda(rs.getInt("modulo_agenda"));
                    userObject.setModulo_caixa(rs.getInt("modulo_caixa"));
                    userObject.setModulo_pessoa(rs.getInt("modulo_pessoa"));
                    userObject.setModulo_cfg(rs.getInt("modulo_cfg"));
                    userObject.setModulo_pessoa_alterar_usuario(rs.getInt("modulo_pessoa_alterar_usuario"));
                    userObject.setModulo_pessoa_funionario(rs.getInt("modulo_pessoa_funcionario"));
                    userObject.setModulo_pessoa_admin(rs.getInt("modulo_pessoa_admin"));
                    userObject.setModulo_relatorios(rs.getInt("modulo_relatorios"));
                    userObject.setInativo(inativo);
                    userObject.setTrocarSenha(rs.getBoolean("trocarSenha"));
                }
                else{
                    System.out.println("NOK");
                    return null;
                }
            }
            pstm.close();
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
        return userObject;
    }

}
