package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Config {
    private JButton funçõesButton;
    private JButton serviçosButton;
    private JButton usuariosButton;
    private JPanel ConfigScreen;

    public Config() {
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

            }
        });
    }

    public JPanel getConfigScreen(){
        return ConfigScreen;
    }
}
