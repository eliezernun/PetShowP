package UI;

import DTO.UserDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Config {
    private JButton funçõesButton;
    private JButton serviçosButton;
    private JButton usuariosButton;
    private JPanel ConfigScreen;


    public Config(UserDTO userObject) {

        funçõesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        serviçosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrocaSenha(userObject);
            }
        });
    }

    public JPanel getConfigScreen(){
        return ConfigScreen;
    }

    private void TrocaSenha(UserDTO userObject){
        TrocaSenhaUI trocaSenhaUI = new TrocaSenhaUI(userObject);
        JPanel configScree_ui = trocaSenhaUI.getTrocaSeha();
        JFrame Janela = new JFrame();
        Janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Janela.setContentPane(configScree_ui);
        Janela.pack();
        Janela.setSize(300,300);
        Janela.setLocationRelativeTo(null);
        Janela.setVisible(true);
        Janela.setTitle("trocar senha");
    }
}
