package UI;

import DAO.FuncaoDAO;
import DAO.PessoaDAO;
import DAO.PetDAO;
import DTO.FuncaoDTO;
import DTO.PessoaDTO;
import DTO.PetDTO;
import DTO.ProfissionalDTO;
import UTIL.ComboItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;


public class Pessoa {
    private JPanel Funcionairo_panel;
    private JPanel Pessoa;
    private JTabbedPane Base;
    private JTextField Nome_Pessoa_text;
    private JTextField Telefone_Pessoa_text;
    private JTextField Endereco_Pessoa_text;
    private JFormattedTextField CPF_Pessoa_text;
    private JTextField DDD_Pessoa_text;
    private JTextField numero;
    private JTextField CEP_Pessoa_text;
    private JTextField Bairro_Pessoa_text;
    private JCheckBox inativo_Pessoa;
    private JTextField numero_endereco_Pessoa_text;
    private JCheckBox Funcionario_Pessoa;
    private JButton Pessoa_cancelar_button;
    private JButton Pessoa_novo_button;
    private JButton Pessoa_cadastrar_novo_button;
    private JButton Pessoa_editar_Button;

    // PET --------------------------
    private JTextField NomeFieldPET;
    private JTextField AniversarioField;
    private JTextField TamanhoField;
    private JTextArea Pet_Comentario;
    private JList list1;
    private JCheckBox pet_inativo_checbox;
    // Funcionairo ----------

    private JButton Pet_salvar_button;
    private JButton Pet_editar_button;
    private JButton Pet_novo_button;

    private JCheckBox whatsappCheckBox;
    private JTextField Funcionario_Numero_Certidao;
    private JTextField Funcionario_Numero_CTPS;
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
    private JButton Pessoa_Procurar_Button;
    private JButton Pet_cancelar_button;
    private JScrollPane Batr;

    private JTable tabela_pets;
    private JTextField id_filter;
    private JTextField Funcionario_demissao;
    private JCheckBox acessoAoSistemaCheckBox;
    PessoaDTO ObjetoPessoa;
    ProfissionalDTO ObjetoProfissional;
    PetDAO pets = new PetDAO();
    List<PetDTO> pts;
    private FuncaoDAO funcaoDAO = new FuncaoDAO();
    private FuncaoDTO funcaoDto = new FuncaoDTO();
    private List<FuncaoDTO> funcoes = funcaoDAO.getFuncoes();
    Component [] components = Pessoa_panel.getComponents();
    Component [] componentsPets = Pets_panel.getComponents();
    Component [] componentsFuncionario = Funcionairo_panel.getComponents();
    Component [] componentsUsuario = User_Panel.getComponents();
    private int cadastrarFuncionario, alterarUsuario, definirAdmin;


    public Pessoa(int pessoa_funcionario, int pessoa_alterar_usuario, int pessoa_admin){

        this.cadastrarFuncionario = pessoa_funcionario;
        this.alterarUsuario = pessoa_alterar_usuario;
        this.definirAdmin = pessoa_admin;
        BloquearItens();
        for (int i = 0; i < funcoes.size(); i++) {
            Funcionario_funcao.addItem(new ComboItem(funcoes.get(i).getDescricao(),String.valueOf(funcoes.get(i).getId())));
        }
        Pessoa_cadastrar_novo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ObjetoPessoa = new PessoaDTO();
                String nome, telefone, endereco, cpf, DDD, cep, bairro;
                boolean inativo = inativo_Pessoa.isSelected() ? true : false;
                boolean funcionario = Funcionario_Pessoa.isSelected() ? true:false;
                nome = Nome_Pessoa_text.getText().toUpperCase();
                telefone = Telefone_Pessoa_text.getText();
                endereco = Endereco_Pessoa_text.getText().toUpperCase();
                cpf = CPF_Pessoa_text.getText().toUpperCase();
                DDD = DDD_Pessoa_text.getText().toUpperCase();
                cep = CEP_Pessoa_text.getText().toUpperCase();
                bairro = Bairro_Pessoa_text.getText().toUpperCase();
                ObjetoPessoa.setNome_pessoa(nome);
                ObjetoPessoa.setDdd_pessoa(DDD);
                ObjetoPessoa.setTelefone_pessoa(telefone);
                ObjetoPessoa.setLogradouro_pessoa(endereco);
                ObjetoPessoa.setCpf_pessoa(cpf);
                ObjetoPessoa.setPessoa_funcionario(funcionario);
                ObjetoPessoa.setPessoa_endereco_cep(cep);
                ObjetoPessoa.setPessoa_bairro(bairro);
                ObjetoPessoa.setPessoa_inativa(inativo);
                PessoaDAO pessoaDAO = new PessoaDAO();
                pessoaDAO.cadastrarPessoa(ObjetoPessoa);
                ObjetoPessoa = pessoaDAO.procurarPessoa(cpf);
                UpdateInfo();
                OrganizarFormulario(7);
                if(pessoa_funcionario == 1 && ObjetoPessoa.getId() != 0){

                }
            }
        });
        Pessoa_novo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input =   JOptionPane.showConfirmDialog(null, "Deseja iniciar um novo cadastro?");
                if(input == 0){
                    ObjetoPessoa.setPessoaLimpar();
                    UpdateInfo();
                    SetarPets();
                    pts.clear();
                    OrganizarFormulario(1);
                }
            }
        });
        Pessoa_cancelar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
                if(i == 0){
                    ObjetoPessoa.setPessoaLimpar();
                    UpdateInfo();
                    SetarPets();
                    pts.clear();
                    OrganizarFormulario(2);
                }
            }
        });
        Pessoa_editar_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrganizarFormulario(3);
            }
        });
        Pessoa_Procurar_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!CPF_Pessoa_text.getText().equals("")){
                    String cpf = CPF_Pessoa_text.getText().replace(".","").replace("-","");
                    PessoaDAO pessoaDao = new PessoaDAO();
                    ObjetoPessoa = pessoaDao.procurarPessoa(cpf);
                    if(ObjetoPessoa.getId() != 0){
                        UpdateInfo();
                        OrganizarFormulario(2);
                        SetarPets();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "O CPF:" + CPF_Pessoa_text.getText() + "Não existe! Verifique os dados e tente novamente!" );
                        CPF_Pessoa_text.requestFocusInWindow();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Informe o CPF!");
                    CPF_Pessoa_text.requestFocusInWindow();
                }
            }
        });
        Pet_salvar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nome_pet, aniversario_pet, Tamanho, comentario;
                boolean inativo;
                Nome_pet = NomeFieldPET.getText();
                aniversario_pet = AniversarioField.getText();
                Tamanho = TamanhoField.getText();
                comentario = Pet_Comentario.getText();
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
        Pet_editar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id_filter.getText().isEmpty() || id_filter.getText().isBlank()){
                    JOptionPane.showMessageDialog(null, "Informe o ID do PET");
                    id_filter.requestFocus();
                }
                else{
                        int text = Integer.parseInt(id_filter.getText());
                    for (int i = 0; i < pts.size(); i++) {
                        int item = pts.get(i).getID();
                        if(item == text){
                            NomeFieldPET.setText(pts.get(i).getNome_pet());
                            AniversarioField.setText(pts.get(i).getAniversario_pet());
                            PET_Tamanho.setSelectedItem(pts.get(i).getTamanho_pet());
                            Pet_Comentario.setText(pts.get(i).getComentario_pet());
                            pet_inativo_checbox.setSelected(pts.get(i).isInativo_pet());
                            OrganizarFormulario(5);
                            return;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Este id não esta relacionado aos pets desse cliente!");
                }
            }
        });

        try {
            MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
            maskCPF.install(CPF_Pessoa_text);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private void SetarPets(){
        String[] columnN = {"ID", "Nome", "Nascimento", "Tamanho", "inativo"};
            pts =  pets.recuperarPets(ObjetoPessoa.getId());
            Object[][] data = new Object[pts.size()][];
            for (int i = 0; i < pts.size(); i++) {
                data[i] = new Object[]{pts.get(i).getID(), pts.get(i).getNome_pet(), pts.get(i).getAniversario_pet(), pts.get(i).getTamanho_pet(), pts.get(i).isInativo_pet() == true ? "Sim" : "Não"};
            }
            tabela_pets.setModel(new DefaultTableModel(data, columnN));
            tabela_pets.setEnabled(false);
            OrganizarFormulario(4);
    }
    private void UpdateInfo(){
            inativo_Pessoa.setSelected(ObjetoPessoa.isPessoa_inativa());
            Funcionario_Pessoa.setSelected(ObjetoPessoa.isPessoa_funcionario());
            whatsappCheckBox.setSelected(ObjetoPessoa.isWhatsapp_pessoa());
            Nome_Pessoa_text.setText(ObjetoPessoa.getNome_pessoa().toUpperCase());
            Nome_Pessoa_text.setEditable(false);
            Telefone_Pessoa_text.setText(ObjetoPessoa.getTelefone_pessoa());
            Telefone_Pessoa_text.setEditable(false);
            Endereco_Pessoa_text.setText(ObjetoPessoa.getLogradouro_pessoa().toUpperCase());
            Endereco_Pessoa_text.setEditable(false);
            CPF_Pessoa_text.setText(ObjetoPessoa.getCpf_pessoa());
            CPF_Pessoa_text.setEditable(false);
            DDD_Pessoa_text.setText(ObjetoPessoa.getDdd_pessoa());
            DDD_Pessoa_text.setEditable(false);
            CEP_Pessoa_text.setText(ObjetoPessoa.getPessoa_endereco_cep());
            CEP_Pessoa_text.setEditable(false);
            Bairro_Pessoa_text.setText(ObjetoPessoa.getPessoa_endereco_bairro().toUpperCase());
            Bairro_Pessoa_text.setEditable(false);
            numero_endereco_Pessoa_text.setText(ObjetoPessoa.getPessoa_endereco_numero());
            numero_endereco_Pessoa_text.setEditable(false);
    }
    private void BloquearItens(){

                for (int i = 0; i < components.length; i++) {
                    components[i].setEnabled(false);
                }
                for (int i = 0; i < componentsPets.length; i++) {
                    componentsPets[i].setEnabled(false);
                }
                for (int i = 0; i < componentsFuncionario.length; i++) {
                    componentsFuncionario[i].setEnabled(false);
                }
                for (int i = 0; i < componentsUsuario.length ; i++) {
                    componentsUsuario[i].setEnabled(false);
                }

                OrganizarFormulario(0);
    }
    private void OrganizarFormulario(int x){
        switch (x){
            case 0 : // desbloqueia os campos iniciais novo e procurar;
                CPF_Pessoa_text.setEnabled(true);
                Pessoa_novo_button.setEnabled(true);
                Pessoa_Procurar_Button.setEnabled(true);
                break;
            case 1: // botão novo
                Component [] components = Pessoa_panel.getComponents();
                for (int i = 0; i < components.length; i++) {
                    components[i].setEnabled(true);
                }
                Pessoa_novo_button.setEnabled(false);
                Pessoa_editar_Button.setEnabled(false);
                Pessoa_Procurar_Button.setEnabled(false);
                if(cadastrarFuncionario == 1){ // verifica se o funcionario pode cadastrar outros funcionarios.
                    Funcionario_Pessoa.setEnabled(true);
                }
                break;
            case 2: // botão procurar
                CPF_Pessoa_text.setEnabled(true);
                CPF_Pessoa_text.setEditable(true);
                Pessoa_novo_button.setEnabled(true);
                Pessoa_Procurar_Button.setEnabled(true);
                Pessoa_editar_Button.setEnabled(true);
                Pessoa_cancelar_button.setEnabled(true);
                break;
            case 3: // botão editar!
                CPF_Pessoa_text.setEnabled(true);
                CPF_Pessoa_text.setEditable(true);
                Nome_Pessoa_text.setEnabled(true);
                Nome_Pessoa_text.setEditable(true);
                DDD_Pessoa_text.setEditable(true);
                DDD_Pessoa_text.setEnabled(true);
                Telefone_Pessoa_text.setEnabled(true);
                Telefone_Pessoa_text.setEditable(true);
                Endereco_Pessoa_text.setEnabled(true);
                Endereco_Pessoa_text.setEditable(true);
                CEP_Pessoa_text.setEnabled(true);
                CEP_Pessoa_text.setEditable(true);
                numero_endereco_Pessoa_text.setEnabled(true);
                numero_endereco_Pessoa_text.setEditable(true);
                Bairro_Pessoa_text.setEnabled(true);
                Bairro_Pessoa_text.setEditable(true);
                Pessoa_novo_button.setEnabled(false);
                Pessoa_cadastrar_novo_button.setEnabled(true);
                Pessoa_editar_Button.setEnabled(false);
                Pessoa_cancelar_button.setEnabled(true);
                inativo_Pessoa.setEnabled(true);
                if(cadastrarFuncionario == 1){
                    Funcionario_Pessoa.setEnabled(true);
                }
                break;

            case 4 :
                Pet_novo_button.setEnabled(true);
                Pet_editar_button.setEnabled(true);
                id_filter.setEnabled(true);
                id_filter.setEditable(true);
                break;
            case 5:
                NomeFieldPET.setEnabled(true);
                NomeFieldPET.setEditable(true);
                AniversarioField.setEditable(true);
                AniversarioField.setEnabled(true);
                PET_Tamanho.setEditable(true);
                PET_Tamanho.setEnabled(true);
                Pet_Comentario.setEditable(true);
                Pet_Comentario.setEnabled(true);
                pet_inativo_checbox.setEnabled(true);
                break;
            case 6:
                Funcionario_Numero_CTPS.setEnabled(true);
                Funcionario_Numero_CTPS.setEditable(true);
                Funcionario_Numero_Certidao.setEnabled(true);
                Funcionario_Numero_Certidao.setEditable(true);
                Funcionario_graduacao.setEnabled(true);
                Funcionario_RG.setEnabled(true);
                Funcionario_RG.setEditable(true);
                Funcionario_reservista.setEditable(true);
                Funcionario_reservista.setEnabled(true);
                Funcionario_PIS.setEnabled(true);
                Funcionario_PIS.setEditable(true);
                Funcionario_Admissao.setEditable(true);
                Funcionario_Admissao.setEnabled(true);
                Funcionario_funcao.setEnabled(true);
                Funcionario_CRMV.setEnabled(true);
                Funcionario_Salario_valor.setEditable(true);
                Funcionario_Salario_valor.setEnabled(true);
                break;
            case 7:
                Funcionario_Numero_CTPS.setEnabled(false);
                Funcionario_Numero_CTPS.setEditable(false);
                Funcionario_Numero_Certidao.setEnabled(false);
                Funcionario_Numero_Certidao.setEditable(false);
                Funcionario_graduacao.setEnabled(false);
                Funcionario_RG.setEnabled(false);
                Funcionario_RG.setEditable(false);
                Funcionario_reservista.setEditable(false);
                Funcionario_reservista.setEnabled(false);
                Funcionario_PIS.setEnabled(false);
                Funcionario_PIS.setEditable(false);
                Funcionario_Admissao.setEditable(false);
                Funcionario_Admissao.setEnabled(false);
                Funcionario_funcao.setEnabled(false);
                Funcionario_CRMV.setEnabled(false);
                Funcionario_Salario_valor.setEditable(false);
                Funcionario_Salario_valor.setEnabled(false);
                Funcionario_BTN_Salvar.setEnabled(false);

                break;
            case 8:
                CPF_Pessoa_text.setEnabled(false);
                CPF_Pessoa_text.setEditable(false);
                Nome_Pessoa_text.setEnabled(false);
                Nome_Pessoa_text.setEditable(false);
                DDD_Pessoa_text.setEditable(false);
                DDD_Pessoa_text.setEnabled(false);
                Telefone_Pessoa_text.setEnabled(false);
                Telefone_Pessoa_text.setEditable(false);
                Endereco_Pessoa_text.setEnabled(false);
                Endereco_Pessoa_text.setEditable(false);
                CEP_Pessoa_text.setEnabled(false);
                CEP_Pessoa_text.setEditable(false);
                numero_endereco_Pessoa_text.setEnabled(false);
                numero_endereco_Pessoa_text.setEditable(false);
                Bairro_Pessoa_text.setEnabled(false);
                Bairro_Pessoa_text.setEditable(false);
                Pessoa_novo_button.setEnabled(true);
                Pessoa_cadastrar_novo_button.setEnabled(false);
                Pessoa_editar_Button.setEnabled(true);
                Pessoa_cancelar_button.setEnabled(false);
                inativo_Pessoa.setEnabled(false);
                Funcionario_Pessoa.setEnabled(false);
                break;
        }
    }
    public JPanel getPessoaPaenel(){
        return Pessoa;
    }


}
