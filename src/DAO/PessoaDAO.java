package DAO;
import DB.DBC;
import DTO.PessoaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PessoaDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    public void cadastrarPessoa(PessoaDTO objPessoa){
        String sql = "insert into Pessoa(Nome, Telefone, logradouro, CPF, funcionario, ddd_telefone, whatsapp, numero, bairro, cep) values(?,?,?,?,?,?,?,?,?,?)";
        conn = new DBC().conectarDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,objPessoa.getNome_pessoa().toUpperCase());
            pstm.setString(2, objPessoa.getTelefone_pessoa().toUpperCase());
            pstm.setString(3, objPessoa.getLogradouro_pessoa().toUpperCase());
            pstm.setString(4, objPessoa.getCpf_pessoa());
            pstm.setBoolean(5, objPessoa.isPessoa_funcionario());
            pstm.setString(6, objPessoa.getDdd_pessoa());
            pstm.setBoolean(7, objPessoa.isWhatsapp_pessoa());
            pstm.setString(8, objPessoa.getPessoa_endereco_numero());
            pstm.setString(9, objPessoa.getPessoa_bairro().toUpperCase());
            pstm.setString(10, objPessoa.getPessoa_endereco_cep());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    public void updatePessoa(PessoaDTO objetoPessoa){
        String sql = "UPDATE Pessoa SET Nome = ?, Telefone=?, ddd_telefone = ?, whatsapp=?, logradouro=?, cep=?, numero=?, bairro= ?, funcionario=?, inativo = ? WHERE CPF = ? ";
        conn = new DBC().conectarDB();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objetoPessoa.getNome_pessoa().toUpperCase());
            pstm.setString(2, objetoPessoa.getTelefone_pessoa());
            pstm.setString(3, objetoPessoa.getDdd_pessoa());
            pstm.setBoolean(4, objetoPessoa.isWhatsapp_pessoa());
            pstm.setString(5,objetoPessoa.getLogradouro_pessoa().toUpperCase());
            pstm.setString(6, objetoPessoa.getPessoa_endereco_cep());
            pstm.setString(7, objetoPessoa.getPessoa_endereco_numero());
            pstm.setString(8,objetoPessoa.getPessoa_bairro().toUpperCase());
            pstm.setBoolean(9, objetoPessoa.isPessoa_funcionario());
            pstm.setBoolean(10, objetoPessoa.isPessoa_inativa());
            pstm.setString(11, objetoPessoa.getCpf_pessoa());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public PessoaDTO procurarPessoa(String cpf){
        PessoaDTO ObjectPessoa = new PessoaDTO();
        String sql = "SELECT * FROM Pessoa WHERE CPF = ?";
        conn = new DBC().conectarDB();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpf);
            rs = pstm.executeQuery();
            while(rs.next()){
               ObjectPessoa.setId(rs.getInt("id"));
               ObjectPessoa.setNome_pessoa(rs.getString("Nome"));
               ObjectPessoa.setDdd_pessoa(rs.getString("ddd_telefone"));
               ObjectPessoa.setTelefone_pessoa(rs.getString("Telefone"));
               ObjectPessoa.setWhatsapp_pessoa(rs.getBoolean("whatsapp"));
               ObjectPessoa.setPessoa_funcionario(rs.getBoolean("funcionario"));
               ObjectPessoa.setCpf_pessoa(rs.getString("CPF"));
               ObjectPessoa.setLogradouro_pessoa(rs.getString("logradouro"));
               ObjectPessoa.setPessoa_endereco_numero(rs.getString("numero"));
               ObjectPessoa.setPessoa_endereco_bairro(rs.getString("bairro"));
               ObjectPessoa.setPessoa_endereco_cep(rs.getString("cep"));
               ObjectPessoa.setPessoa_inativa(rs.getBoolean("inativo"));
            }
            pstm.close();
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

        return ObjectPessoa;
    }

}
