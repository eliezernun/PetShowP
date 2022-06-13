package DAO;
import DB.DBC;
import DTO.PessoaDTO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {
    Connection conn;
    PreparedStatement pstm;
    public void cadastrarPessoa(PessoaDTO objPessoa){
        String sql = "insert into Pessoa(Nome, Telefone, logradouro, CPF, funcionario, ddd_telefone, whatsapp, numero, bairro, cep) values(?,?,?,?,?,?,?,?,?,?)";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,objPessoa.getNome_pessoa());
            pstm.setString(2, objPessoa.getTelefone_pessoa());
            pstm.setString(3, objPessoa.getLogradouro_pessoa());
            pstm.setString(4, objPessoa.getCpf_pessoa());
            pstm.setBoolean(5, objPessoa.isPessoa_funcionario());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

}
