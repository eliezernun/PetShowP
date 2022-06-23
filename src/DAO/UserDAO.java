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
        String sql = "SELECT * FROM Usuarios_Sistema WHERE usuario = ?";
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
                    userObject.setAutenticado(true);

                }
                else{
                    userObject.setAutenticado(false);
                }
            }
            pstm.close();
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
        finally {
            return userObject;
        }
    }
    public void setUser(UserDTO userObject){
        String sql = "insert into Usuario_Sistema(profissional_id, usuario, senha, modulo_pessoa, modulo_agenda, " +
                "modulo_caixa, modulo_config, modulo_pessoa_funcionario, modulo_pessoa_alterar_usuario, " +
                "modulo_pessoa_admin, modulo_relatorios, trocarSenha, inativo) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        conn = new DBC().conectarDB();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, userObject.getProfissional_id());
            pstm.setString(2, userObject.getUsuario());
            pstm.setString(3, "YWJjMTIz");
            pstm.setInt(4, userObject.getModulo_pessoa());
            pstm.setInt(5, userObject.getModulo_agenda());
            pstm.setInt(6, 0);
            pstm.setInt(7, userObject.getModulo_pessoa_funionario());
            pstm.setInt(8, userObject.getModulo_pessoa_alterar_usuario());
            pstm.setInt(9, userObject.getModulo_pessoa_admin());
            pstm.setInt(10, 0);
            pstm.setInt(11,0);
            pstm.setBoolean(12, userObject.isInativo());
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateUser(UserDTO userObject){
        String sql= "UPDATE Usuarios_Sistemas inativo=?, usuario=?, senha=?, modulo_pessoa=?, modulo_agenda=?," +
                "modulo_caixa=?, modulo_config=?, modulo_pessoa_funcionario=?, modulo_pessoa_alterar_usuario=?," +
                "modulo_pessoa_admin=?, modulo_relatorios=?, trocarSenha=?, WHERE Profissional_id=?";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setBoolean(1, userObject.isInativo());
            pstm.setString(2, userObject.getUsuario());
            pstm.setString(3, userObject.getSenha());
            pstm.setInt(4, userObject.getModulo_pessoa());
            pstm.setInt(5, userObject.getModulo_agenda());
            pstm.setInt(6, 0);
            pstm.setInt(7, userObject.getModulo_pessoa_funionario());
            pstm.setInt(8, userObject.getModulo_pessoa_alterar_usuario());
            pstm.setInt(9, userObject.getModulo_pessoa_admin());
            pstm.setInt(10, 0);
            pstm.setInt(11,0);
            pstm.setInt(12, userObject.getProfissional_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateSenha(String usuario, String senha){
        String sql = "UPDATE Usuarios_Sistema SET senha=? Where usuario = ?";
        conn = new DBC().conectarDB();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, senha);
            pstm.setString(2, usuario);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public UserDTO getUserProps(int id){
        String sql = "SELECT * FROM Usuarios_Sistema WHERE profissional_id = ?";
        conn = new DBC().conectarDB();
        UserDTO userObject = new UserDTO();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet  rs = pstm.executeQuery();
            while(rs.next()){
                boolean inativo = rs.getBoolean("inativo");

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
                    userObject.setAutenticado(true);
            }
            pstm.close();
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
        finally {

            return userObject;
        }
    }
}

