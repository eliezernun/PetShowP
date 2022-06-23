package UI;

import DAO.*;
import DTO.*;
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
    private JComboBox Funcionario_graduacao;
    private JComboBox Funcionario_funcao;
    private JTextField Funcionario_CRMV;
    private JTextField usuario;
    private JCheckBox Usuario_CheckBox_Modu_Pessoa;
    private JCheckBox Usuario_CheckBox_Modu_Agenda;
    private JCheckBox Usuario_CheckBox_Modu_Config;
    private JCheckBox Usuario_CheckBox_Perm_Cad_Func;
    private JCheckBox Usuario_CheckBox_Perm_Alt_User;
    private JCheckBox Usuario_CheckBox_Perm_Adm;
    private JCheckBox Usuario_CheckBox_Perm_Rel;
    private JButton Usuario_BTN_SAlvar;
    private JButton Usuario_BTN_Reset_Senha;
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

    private JCheckBox acessoAoSistemaCheckBox;
    private JFormattedTextField Funcionario_RG;
    private JFormattedTextField Funcionario_PIS;
    private JFormattedTextField Funcionario_Numero_CTPS;
    private JFormattedTextField Funcionario_Numero_Certidao;
    private JFormattedTextField Funcionario_reservista;
    private JFormattedTextField Funcionario_Admissao;
    private JFormattedTextField Funcionario_demissao;
    PessoaDTO ObjetoPessoa;
    ProfissionalDAO profissionalDAO = new ProfissionalDAO();
    ProfissionalDTO ObjetoProfissional;
    PetDAO pets = new PetDAO();
    PetDTO pet = new PetDTO();
    UserDTO userDTO = new UserDTO();
    UserDAO userDAO = new UserDAO();
    List<PetDTO> pts;
    private FuncaoDAO funcaoDAO = new FuncaoDAO();
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
        OrganizarFormulario(7);
        for (int i = 0; i < funcoes.size(); i++) {
            Funcionario_funcao.addItem(new ComboItem(funcoes.get(i).getDescricao(),String.valueOf(funcoes.get(i).getId())));
        }
        Pessoa_cadastrar_novo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome, telefone, endereco, cpf, DDD, cep, bairro;
                boolean inativo = inativo_Pessoa.isSelected() ? true : false;
                boolean funcionario = Funcionario_Pessoa.isSelected() ? true:false;
                nome = Nome_Pessoa_text.getText().toUpperCase();
                telefone = Telefone_Pessoa_text.getText();
                endereco = Endereco_Pessoa_text.getText().toUpperCase();
                cpf = CPF_Pessoa_text.getText().replace(".","").replace("-","");
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

                if(ObjetoPessoa.getId() == 0){
                    PessoaDAO pessoaDAO = new PessoaDAO();
                    pessoaDAO.cadastrarPessoa(ObjetoPessoa);
                    ObjetoPessoa = pessoaDAO.procurarPessoa(cpf);
                    UpdateInfo();
                    OrganizarFormulario(7);
                }
                else{
                    PessoaDAO pessoaDAO = new PessoaDAO();
                    pessoaDAO.updatePessoa(ObjetoPessoa);
                    ObjetoPessoa = pessoaDAO.procurarPessoa(cpf);
                    UpdateInfo();
                    OrganizarFormulario(7);
                }
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
                    OrganizarFormulario(11);
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
                        if(ObjetoPessoa.isPessoa_funcionario()){
                            SetarFuncionario(1);
                            OrganizarFormulario(7);
                            if(cadastrarFuncionario == 1){
                                Funcionario_BTN_Editar.setEnabled(true);
                            }
                        }
                        else{
                            SetarFuncionario(0);
                            OrganizarFormulario(7);
                        }
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
                String Nome_pet, aniversario_pet, comentario;
                boolean inativo;
                Nome_pet = NomeFieldPET.getText();
                aniversario_pet = AniversarioField.getText();
                comentario = Pet_Comentario.getText();
                inativo = pet_inativo_checbox.isSelected();
                pet.setNome_pet(Nome_pet);
                pet.setAniversario_pet(aniversario_pet);
                pet.setComentario_pet(comentario);
                pet.setInativo_pet(inativo);
                PetDAO petDAO = new PetDAO();
                System.out.println("pet id" + pet.getID());
                if(pet.getID() == 0){
                    petDAO.cadastrarPET(pet);
                    pet.limpar();
                    SetarPets();
                    PetForm();
                }
                else{
                    petDAO.updatePets(pet);
                    pet.limpar();
                    SetarPets();
                    PetForm();
                }

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
                            pet.setID(pts.get(i).getID());
                            AniversarioField.setText(pts.get(i).getAniversario_pet());
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
            MaskFormatter maskRG = new MaskFormatter("##.###.###-##");
            maskRG.install(Funcionario_RG);
            MaskFormatter maskPIS = new MaskFormatter("###.#####.##-#");
            maskPIS.install(Funcionario_PIS);
            MaskFormatter maskCTP = new MaskFormatter("########-#####");
            maskCTP.install(Funcionario_Numero_CTPS);
            MaskFormatter maskCert = new MaskFormatter("###### ## ## #### # ##### ### ####### ##");
            maskCert.install(Funcionario_Numero_Certidao);
            MaskFormatter maskRes = new MaskFormatter("######");
            maskRes.install(Funcionario_reservista);
            MaskFormatter date = new MaskFormatter("####/##/##");
            date.install(Funcionario_demissao);
            MaskFormatter date2 = new MaskFormatter("####/##/##");
            date2.install(Funcionario_Admissao);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Pet_cancelar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrganizarFormulario(1);
                SetarPets();
            }
        });
        Funcionario_BTN_Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetarFuncionario(1);
                OrganizarFormulario(1);
            }
        });
        Funcionario_BTN_Editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(ObjetoPessoa.getId() != 0 && ObjetoPessoa.isPessoa_funcionario() == true){
                   OrganizarFormulario(9);
               }
               else{
                   OrganizarFormulario(7);
               }
            }
        });
        Pet_novo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pet.limpar();
                pet.setId_dono(ObjetoPessoa.getId());
                OrganizarFormulario(5);
            }
        });
        Funcionario_BTN_Salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nctps , ncertidao, npis, nrg, nmil, ncrmv;
                double sal;
                     nctps = Funcionario_Numero_CTPS.getText()
                             .replace(".","")
                             .replace("-","")
                             .replace(" ", "");
                     ncertidao = Funcionario_Numero_Certidao.getText().replace(" ", "");
                     npis = Funcionario_PIS.getText().replace(".","").replace("-","");
                     nrg  = Funcionario_RG.getText().replace(".","").replace("-","");
                     nmil = Funcionario_reservista.getText().replace(".","").replace("-","");
                     ncrmv  = Funcionario_CRMV.getText();
                     sal = Double.parseDouble(Funcionario_Salario_valor.getText());
                     String datades = Funcionario_demissao.getText().replace("/", "");
                     String dataDesligamento = null;
                     if(!datades.isEmpty() && !datades.isBlank() && !datades.contains(" ")) {
                         dataDesligamento = Funcionario_demissao.getText().replace("/", "-");
                     }
                ObjetoProfissional.setId_pessoa(ObjetoPessoa.getId());
                ObjetoProfissional.setNumero_ctps(nctps);
                ObjetoProfissional.setNumero_certidao(ncertidao);
                ObjetoProfissional.setNumero_pis(npis);
                ObjetoProfissional.setNumero_rg(nrg);
                ObjetoProfissional.setNumero_reservista(nmil);
                ObjetoProfissional.setNumero_crmv(ncrmv);
                ObjetoProfissional.setSalario(sal);
                ObjetoProfissional.setAcesso_sistema(acessoAoSistemaCheckBox.isSelected());

                ComboItem var = (ComboItem) Funcionario_funcao.getSelectedItem();

                ObjetoProfissional.setId_funcao(Integer.parseInt(var.getKey()));
                if(ObjetoProfissional.getId() == 0){
                    System.out.println("as");
                    profissionalDAO.cadastrarProfissional(ObjetoProfissional);
                    OrganizarFormulario(7);
                }
                else{
                    System.out.println("os");
                    profissionalDAO.updateProfissional(ObjetoProfissional);
                    OrganizarFormulario(7);
                }

            }
        });
        Usuario_BTN_Editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrganizarFormulario(13);
            }
        });
        Usuario_BTN_SAlvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userDTO.setUsuario(usuario.getText());
                int mp = Usuario_CheckBox_Modu_Pessoa.isSelected() == true ? 1 : 0;
                userDTO.setModulo_pessoa(mp);
                int cfg = Usuario_CheckBox_Modu_Config.isSelected() == true ? 1 : 0;
                userDTO.setModulo_cfg(cfg);
                int cfu = Usuario_CheckBox_Perm_Cad_Func.isSelected() == true ? 1: 0;
                userDTO.setModulo_pessoa_alterar_usuario(cfu);
                int alt = Usuario_CheckBox_Perm_Alt_User.isSelected() == true ? 1 : 0;
                userDTO.setModulo_pessoa_alterar_usuario(alt);
                int adm = Usuario_CheckBox_Perm_Adm.isSelected() == true ? 1 : 0;
                userDTO.setModulo_pessoa_admin(adm);
                int rel = Usuario_CheckBox_Perm_Rel.isSelected() == true ? 1: 0;
                userDTO.setModulo_relatorios(rel);
                userDAO.setUser(userDTO);

            }
        });
    }
    private void SetarPets(){
        String[] columnN = {"ID", "Nome", "Nascimento", "inativo"};
            pts =  pets.recuperarPets(ObjetoPessoa.getId());
            Object[][] data = new Object[pts.size()][];
            for (int i = 0; i < pts.size(); i++) {
                data[i] = new Object[]{pts.get(i).getID(), pts.get(i).getNome_pet(), pts.get(i).getAniversario_pet(), pts.get(i).isInativo_pet() == true ? "Sim" : "Não"};
            }
            tabela_pets.setModel(new DefaultTableModel(data, columnN));
            tabela_pets.setEnabled(false);
            OrganizarFormulario(4);
    }
    private void SetarFuncionario(int x){
        if(x == 1){

            ObjetoProfissional = profissionalDAO.getDadosProfissional(ObjetoPessoa.getId());
            Funcionario_Numero_CTPS.setText(String.valueOf(ObjetoProfissional.getNumero_ctps()));
            Funcionario_Numero_Certidao.setText(String.valueOf(ObjetoProfissional.getNumero_certidao()));
            Funcionario_PIS.setText(String.valueOf(ObjetoProfissional.getNumero_pis()));
            Funcionario_RG.setText(String.valueOf(ObjetoProfissional.getNumero_rg()));
            Funcionario_reservista.setText(String.valueOf(ObjetoProfissional.getNumero_reservista()));
            Funcionario_CRMV.setText(String.valueOf(ObjetoProfissional.getNumero_crmv()));
            Funcionario_Admissao.setText(String.valueOf(ObjetoProfissional.getData_admi()));
            Funcionario_demissao.setText(String.valueOf(ObjetoProfissional.getData_des()));
            Funcionario_Salario_valor.setText(String.valueOf(ObjetoProfissional.getSalario()));
            Funcionario_funcao.setSelectedItem(ObjetoProfissional.getId_funcao());
            acessoAoSistemaCheckBox.setSelected(ObjetoProfissional.isAcesso_sistema());
            if(ObjetoProfissional.isAcesso_sistema() && alterarUsuario == 1){
                Usuario_BTN_Editar.setEnabled(true);

            }
        }
        else{

            Funcionario_Numero_CTPS.setText("");
            Funcionario_Numero_Certidao.setText("");
            Funcionario_PIS.setText("");
            Funcionario_RG.setText("");
            Funcionario_reservista.setText("");
            Funcionario_CRMV.setText("");
            Funcionario_Admissao.setText("19001201");
            Funcionario_demissao.setText("19001201");
            Funcionario_Salario_valor.setText("");
            Funcionario_funcao.setSelectedItem(1);
            acessoAoSistemaCheckBox.setSelected(false);
        }
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

    private void PetForm(){
        NomeFieldPET.setText(pet.getNome_pet());
        pet.setID(pet.getID());
        AniversarioField.setText(pet.getAniversario_pet());
        Pet_Comentario.setText(pet.getComentario_pet());
        pet_inativo_checbox.setSelected(pet.isInativo_pet());
        OrganizarFormulario(5);
    }
    private void OrganizarFormulario(int x){
        switch (x){
            case 0 : // desbloqueia os campos iniciais novo e procurar;
                CPF_Pessoa_text.setEnabled(true);
                Pessoa_novo_button.setEnabled(true);
                Pessoa_Procurar_Button.setEnabled(true);
                Funcionario_demissao.setEnabled(false);
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
                    Funcionario_BTN_Editar.setEnabled(true);
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
                CPF_Pessoa_text.setEnabled(false);
                CPF_Pessoa_text.setEditable(false);
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
                Pessoa_Procurar_Button.setEnabled(false);
                inativo_Pessoa.setEnabled(true);
                if(cadastrarFuncionario == 1){
                    Funcionario_Pessoa.setEnabled(true);
                }
                break;

            case 4 : // basico pet
                Pet_novo_button.setEnabled(true);
                Pet_editar_button.setEnabled(true);
                id_filter.setEnabled(true);
                id_filter.setEditable(true);
                break;
            case 5: // editarpet
                NomeFieldPET.setEnabled(true);
                NomeFieldPET.setEditable(true);
                AniversarioField.setEditable(true);
                AniversarioField.setEnabled(true);
                Pet_Comentario.setEditable(true);
                Pet_Comentario.setEnabled(true);
                pet_inativo_checbox.setEnabled(true);
                Pet_salvar_button.setEnabled(true);
                id_filter.setEnabled(false);
                id_filter.setEditable(false);
                break;
            case 6: // editar funcionario
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
            case 7: // bloquear funcionario
                Funcionario_Numero_CTPS.setEnabled(false);
                Funcionario_Numero_CTPS.setEditable(false);
                Funcionario_Numero_Certidao.setEnabled(false);
                Funcionario_Numero_Certidao.setEditable(false);
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
                Pessoa_cadastrar_novo_button.setEnabled(true);
                Funcionario_BTN_Editar.setEnabled(false);

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
            case 9:
                Funcionario_Numero_CTPS.setEditable(true);
                Funcionario_Numero_CTPS.setEnabled(true);
                Funcionario_Numero_Certidao.setEditable(true);
                Funcionario_Numero_Certidao.setEnabled(true);
                Funcionario_PIS.setEditable(true);
                Funcionario_PIS.setEnabled(true);
                Funcionario_RG.setEnabled(true);
                Funcionario_RG.setEditable(true);
                Funcionario_reservista.setEditable(true);
                Funcionario_reservista.setEnabled(true);
                Funcionario_CRMV.setEditable(true);
                Funcionario_CRMV.setEnabled(true);
                Funcionario_Admissao.setEditable(true);
                Funcionario_Admissao.setEnabled(true);
                Funcionario_funcao.setEnabled(true);
                Funcionario_funcao.setEditable(false);
                Funcionario_Salario_valor.setEnabled(true);
                Funcionario_Salario_valor.setEditable(true);
                Funcionario_demissao.setEnabled(true);
                Funcionario_demissao.setEditable(true);
                Funcionario_BTN_Salvar.setEnabled(true);
                Funcionario_BTN_Cancelar.setEnabled(true);
                Funcionario_BTN_Editar.setEnabled(false);
                acessoAoSistemaCheckBox.setEnabled(false);
                if(alterarUsuario == 1){
                    acessoAoSistemaCheckBox.setEnabled(true);
                }

                break;
            case 10:
                Funcionario_Numero_CTPS.setEditable(false);
                Funcionario_Numero_CTPS.setEnabled(false);
                Funcionario_Numero_Certidao.setEditable(false);
                Funcionario_Numero_Certidao.setEnabled(false);
                Funcionario_PIS.setEditable(false);
                Funcionario_PIS.setEnabled(false);
                Funcionario_RG.setEnabled(false);
                Funcionario_RG.setEditable(false);
                Funcionario_reservista.setEditable(false);
                Funcionario_reservista.setEnabled(false);
                Funcionario_CRMV.setEditable(false);
                Funcionario_CRMV.setEnabled(false);
                Funcionario_Admissao.setEditable(false);
                Funcionario_Admissao.setEnabled(false);
                Funcionario_funcao.setEnabled(false);
                Funcionario_funcao.setEditable(false);
                Funcionario_Salario_valor.setEnabled(false);
                Funcionario_Salario_valor.setEditable(false);
                Funcionario_demissao.setEnabled(false);
                Funcionario_demissao.setEditable(false);
                acessoAoSistemaCheckBox.setEnabled(false);
                break;
            case 11:
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
                Pessoa_Procurar_Button.setEnabled(false);
                inativo_Pessoa.setEnabled(true);
                if(cadastrarFuncionario == 1){
                    Funcionario_Pessoa.setEnabled(true);
                }
                break;
            case 12:
                NomeFieldPET.setEnabled(false);
                NomeFieldPET.setEditable(false);
                AniversarioField.setEditable(false);
                AniversarioField.setEnabled(false);
                Pet_Comentario.setEditable(false);
                Pet_Comentario.setEnabled(false);
                pet_inativo_checbox.setEnabled(false);
                Pet_salvar_button.setEnabled(false);
                id_filter.setEnabled(true);
                id_filter.setEditable(true);
                Pet_editar_button.setEnabled(true);
                Pet_cancelar_button.setEnabled(false);
                break;
            case 13:
                Usuario_CheckBox_Modu_Pessoa.setEnabled(true);
                Usuario_CheckBox_Modu_Agenda.setEnabled(true);
                Usuario_CheckBox_Perm_Cad_Func.setEnabled(true);
                Usuario_CheckBox_Perm_Rel.setEnabled(true);
                Usuario_CheckBox_Perm_Alt_User.setEnabled(false);
                Usuario_CheckBox_Perm_Adm.setEnabled(false);
                if(alterarUsuario == 1){
                    Usuario_CheckBox_Perm_Alt_User.setEnabled(true);
                    Usuario_CheckBox_Perm_Adm.setEnabled(true);
                }
                Usuario_BTN_Cancelar.setEnabled(true);
                Usuario_BTN_Editar.setEnabled(false);
                Usuario_BTN_SAlvar.setEnabled(true);
                Usuario_BTN_Reset_Senha.setEnabled(true);

                break;
        }
    }
    public JPanel getPessoaPaenel(){
        return Pessoa;
    }


}
