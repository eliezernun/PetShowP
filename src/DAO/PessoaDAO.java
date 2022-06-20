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
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

        return ObjectPessoa;
    }

}
