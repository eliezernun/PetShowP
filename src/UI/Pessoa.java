package UI;

import DTO.PessoaDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pessoa {
    private JPanel Pessoa;
    private JTabbedPane tabbedPane1;
    private JTextField Nome;
    private JTextField Telefone;
    private JTextField Endereco;
    private JTextField CPF;
    private JTextField NomeField;
    private JTextField AniversarioField;
    private JTextField TamanhoField;
    private JTextArea textArea1;
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
            }
        });
    }

    public JPanel getPessoaPaenel(){
        return Pessoa;
    }
}
