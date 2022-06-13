package UI;

import DTO.TrocaSenhaDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Troca_Senha_UI {
    private JPanel TrocaSenha_Panel;
    private JPasswordField Senha_field_1;
    private JPasswordField Senha_field_2;
    private JButton Cancelar_button_Troca_Senha;
    private JButton Trocar_Senha_Salvar;
    private JLabel Text_error;

    public Troca_Senha_UI() {
        Trocar_Senha_Salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrocaSenhaDTO trocaSenhaDTO = new TrocaSenhaDTO();
                trocaSenhaDTO.setSenha(String.valueOf(Senha_field_1.getPassword()));
                trocaSenhaDTO.setSenha_Repetir(String.valueOf(Senha_field_2.getPassword()));
                boolean truePass = trocaSenhaDTO.SenhaCompare();
                if(!truePass){
                    Text_error.setText("As senhas não são iguais!");
                }

            }
        });
        Cancelar_button_Troca_Senha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
