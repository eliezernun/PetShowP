package UI;

import DTO.UserDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JButton pessoasButton;
    private JButton agendaButton;
    private JButton CaixaButton;
    private JButton configButton;
    private JPanel MenuPrincipal;
    private JButton funçõesButton;

    public JPanel getMenuPrincipal(){
        return MenuPrincipal;
    }

    public Menu(UserDTO userObject) {
        if(userObject.isTrocarSenha()){
            System.out.println("trocarSenha");
        }
        if(userObject.getModulo_pessoa() == 0 ){
            pessoasButton.setEnabled(false);
        }
        if(userObject.getModulo_agenda() == 0){
            agendaButton.setEnabled(false);
        }
        if(userObject.getModulo_caixa() == 0){
            CaixaButton.setEnabled(false);
        }
        if(userObject.getModulo_cfg() == 0){
            configButton.setEnabled(false);
        }
        pessoasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaScreen();
            }
            private void PessoaScreen(){
                Pessoa pessoaScreen = new Pessoa(userObject.getModulo_pessoa_funionario(), userObject.getModulo_pessoa_alterar_usuario(), userObject.getModulo_pessoa_admin());
                JPanel PessoaScreen_ui = pessoaScreen.getPessoaPaenel();
                JFrame Janela = new JFrame();
                Janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Janela.setContentPane(PessoaScreen_ui);
                Janela.pack();
                Janela.setSize(800,600);
                Janela.setLocationRelativeTo(null);
                Janela.setVisible(true);
                Janela.setTitle("PetShowP");
            }
        });
        agendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        CaixaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        configButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigScreen();
            }

            private void ConfigScreen(){
                Config configScreen = new Config();
                JPanel configScree_ui = configScreen.getConfigScreen();
                JFrame Janela = new JFrame();
                Janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Janela.setContentPane(configScree_ui);
                Janela.pack();
                Janela.setSize(300,300);
                Janela.setLocationRelativeTo(null);
                Janela.setVisible(true);
                Janela.setTitle("Configurações");
            }

        });


        funçõesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Funcoens_UI FuncoensUI = new Funcoens_UI();
               JPanel funcoensScreenUI = FuncoensUI.getFuncoes_panel();
                JFrame Janela = new JFrame();
                Janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Janela.setContentPane(funcoensScreenUI);
                Janela.pack();
                Janela.setSize(500,350);
                Janela.setLocationRelativeTo(null);
                Janela.setVisible(true);
                Janela.setTitle("Funções");
            }
        });
    }
}
