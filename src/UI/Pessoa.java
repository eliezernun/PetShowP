package UI;

import DAO.PessoaDAO;
import DAO.PetDAO;
import DTO.PessoaDTO;
import DTO.PetDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pessoa {
    private JPanel Funcionairo_panel;
    private JPanel Pessoa;
    private JTabbedPane Base;
    private JTextField Nome_Pessoa;
    private JTextField Telefone_Pessoa;
    private JTextField Endereco_Pessoa;
    private JTextField CPF;
    private JTextField DDD_Pessoa;
    private JTextField numero;
    private JTextField CEP_Pessoa;
    private JTextField Bairro_Pessoa;
    private JCheckBox inativo_pessoa;
    private JTextField numero_endereco_pessoa;
    private JCheckBox Funcionario_pessaoa;
    private JButton Pessoa_cancelar_button;
    private JButton Pessoa_novo_button;
    private JButton Pessoa_cadastrar_novo_button;

    // PET --------------------------
    private JTextField NomeFieldPET;
    private JTextField AniversarioField;
    private JTextField TamanhoField;
    private JTextArea Comentario;
    private JList list1;
    private JCheckBox pet_inativo_checbox;
    // Funcionairo ----------

    private JButton salvarButton;
    private JButton editarButton;
    private JButton novoButton;

    private JCheckBox whatsappCheckBox;
    private JTextField Funcionario_Numero_Certidao;
    private JTextField Funcinario_Numero_CTPS;
    private JComboBox Funcionario_graduacao;
    private JTextField Funcionario_RG;
    private JTextField Funcionario_reservista;
    private JTextField Funcionario_PIS;
    private JTextField Funcionario_Admissao;
    private JComboBox Funcionario_funcao;
    private JTextField Funcionario_CRMV;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox Usuario_CheckBox_Modu_Pessoa;
    private JCheckBox Usuario_CheckBox_Modu_Agenda;
    private JCheckBox Usuario_CheckBox_Modu_Caixa;
    private JCheckBox Usuario_CheckBox_Modu_Config;
    private JCheckBox Usuario_CheckBox_Perm_Cad_Func;
    private JCheckBox Usuario_CheckBox_Perm_Alt_User;
    private JCheckBox Usuario_CheckBox_Perm_Adm;
    private JCheckBox Usuario_CheckBox_Perm_Rel;
    private JButton Usuario_BTN_SAlvar;
    private JButton Usuario_BTN_Reset_Senha;
    private JComboBox PET_Tamanho;
    private JFormattedTextField Funcionario_Salario_valor;
    private JButton Funcionario_BTN_Salvar;
    private JButton Funcionario_BTN_Editar;
    private JButton Funcionario_BTN_Cancelar;
    private JButton Usuario_BTN_Editar;
    private JButton Usuario_BTN_Cancelar;
    private JPanel Pets_panel;
    private JPanel User_Panel;
    private JPanel Pessoa_panel;

    public Pessoa(int pessoa_funcionario, int pessoa_alterar_usuario, int pessoa_admin) {
        Funcionario_graduacao.setEditable(false);
        Funcionario_funcao.setEditable(false);
        PET_Tamanho.setEditable(false);
        boolean check = Funcionario_pessaoa.isSelected();
        if(pessoa_funcionario == 0 || !check){

            Funcionario_pessaoa.setEnabled(false);
            Funcinario_Numero_CTPS.setEnabled(false);
            Funcionario_Numero_Certidao.setEnabled(false);
            Funcionario_graduacao.setEnabled(false);
            Funcionario_RG.setEnabled(false);
            Funcionario_reservista.setEnabled(false);
            Funcionario_PIS.setEnabled(false);
            Funcionario_Admissao.setEnabled(false);
            Funcionario_funcao.setEnabled(false);
            Funcionario_CRMV.setEnabled(false);
            Funcionario_Salario_valor.setEnabled(false);
            Funcionario_BTN_Salvar.setEnabled(false);
            Funcionario_BTN_Editar.setEnabled(false);
        }
        else{
            Funcionario_pessaoa.setEnabled(true);
        }
        Pessoa_cadastrar_novo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome, telefone, endereco, cpf, DDD, cep, bairro;
                boolean inativo = inativo_pessoa.isSelected() ? true : false;
                boolean funcionario = Funcionario_pessaoa.isSelected() ? true:false;
                nome = Nome_Pessoa.getText().toUpperCase();
                telefone = Telefone_Pessoa.getText();
                endereco = Endereco_Pessoa.getText().toUpperCase();
                cpf = CPF.getText().toUpperCase();
                DDD = DDD_Pessoa.getText().toUpperCase();
                cep = CEP_Pessoa.getText().toUpperCase();
                bairro = Bairro_Pessoa.getText().toUpperCase();
                PessoaDTO ObjetoPessoa = new PessoaDTO();
                ObjetoPessoa.setNome_pessoa(nome);
                ObjetoPessoa.setDdd_pessoa(DDD);
                ObjetoPessoa.setTelefone_pessoa(telefone);
                ObjetoPessoa.setLogradouro_pessoa(endereco);
                ObjetoPessoa.setCpf_pessoa(cpf);
                ObjetoPessoa.setPessoa_funcionario(funcionario);
                ObjetoPessoa.setPessoa_endereco_cep(cep);
                ObjetoPessoa.setPessoa_bairro(bairro);
                ObjetoPessoa.setPessoa_inativa(inativo);
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
                inativo = pet_inativo_checbox.isSelected();
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
