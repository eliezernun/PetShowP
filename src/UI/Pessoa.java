package UI;

import DAO.PessoaDAO;
import DAO.PetDAO;
import DTO.PessoaDTO;
import DTO.PetDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

public class Pessoa {
    private JPanel Pessoa;
    private JTabbedPane tabbedPane1;
    private JTextField Nome;
    private JTextField Telefone;
    private JTextField Endereco;
    private JTextField CPF;
    private JTextField NomeFieldPET;
    private JTextField AniversarioField;
    private JTextField TamanhoField;
    private JTextArea Comentario;
    private JTextField textField7;
    private JList list1;
    private JCheckBox funcionarioCheckBox;
    private JCheckBox inativoCheckBoxPessoa;
    private JCheckBox inativoCheckBoxPet;
    private JButton salvarButton;
    private JButton editarButton;
    private JButton novoButton;
    private JButton canclearButton;
    private JButton novoButton1;
    private JButton cadastrarSalvarButton;

    public Pessoa() {
        cadastrarSalvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome, telefone, endereco, cpf;
                boolean inativo;
                nome = Nome.getText();
                telefone = Telefone.getText();
                endereco = Endereco.getText();
                cpf = CPF.getText();
                inativo = inativoCheckBoxPessoa.isSelected();
                PessoaDTO ObjetoPessoa = new PessoaDTO();
                ObjetoPessoa.setNome_pessoa(nome);
                ObjetoPessoa.setTelefone_pessoa(telefone);
                ObjetoPessoa.setLogradouro_pessoa(endereco);
                ObjetoPessoa.setCpf_pessoa(cpf);
                ObjetoPessoa.setPessoa_funcionario(inativo);
                PessoaDAO objfuncionarioDAO = new PessoaDAO();
                objfuncionarioDAO.cadastrarPessoa(ObjetoPessoa);
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nome_pet, aniversario_pet, Tamanho, comentario;
                boolean inativo;
                Nome_pet = NomeFieldPET.getText();
                aniversario_pet = AniversarioField.getText();
                Tamanho = TamanhoField.getText();
                comentario = Comentario.getText();
                inativo = inativoCheckBoxPet.isSelected();
                PetDTO petDTO = new PetDTO();
                petDTO.setNome_pet(Nome_pet);
                petDTO.setAniversario_pet(aniversario_pet);
                petDTO.setTamanho_pet(Tamanho);
                petDTO.setComentario_pet(comentario);
                petDTO.setInativo_pet(inativo);
                PetDAO petDAO = new PetDAO();
                petDAO.cadastrarPET(petDTO);
            }
        });
    }

    public JPanel getPessoaPaenel(){
        return Pessoa;
    }
}
