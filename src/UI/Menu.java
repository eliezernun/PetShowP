package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JButton pessoasButton;
    private JButton agendaButton;
    private JButton profissionaisButton;
    private JButton configButton;
    private JPanel MenuPrincipal;

    public JPanel getMenuPrincipal(){
        return MenuPrincipal;
    }

    public Menu() {
        pessoasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PessoaScreen();
            }
            private void PessoaScreen(){
                Pessoa pessoaScreen = new Pessoa();
                JPanel PessoaScreen_ui = pessoaScreen.getPessoaPaenel();
                JFrame Janela = new JFrame();
                Janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Janela.setContentPane(PessoaScreen_ui);
                Janela.pack();
                Janela.setSize(800,600);
                Janela.setLocationRelativeTo(null);
                Janela.setVisible(true);
                Janela.setTitle("PetShowP ->");
            }
        });
        agendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        profissionaisButton.addActionListener(new ActionListener() {
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


    }
}
