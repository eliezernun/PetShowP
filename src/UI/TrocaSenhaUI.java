package UI;

import DAO.UserDAO;
import DTO.UserDTO;
import UTIL.PW_Encrypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrocaSenhaUI {
    private JPasswordField Senha_Antiga;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPanel trocaSenha;
    private JButton salvarButton;
    private JButton cancelarButton;
    private UserDAO userDAO = new UserDAO();

    TrocaSenhaUI(UserDTO Oboject){

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senha_a = String.valueOf(Senha_Antiga.getPassword());
                PW_Encrypt pw_encrypt = new PW_Encrypt();
                String senha_a_e = pw_encrypt.PW_Encrypt(senha_a);
                if(senha_a_e.contains(Oboject.getSenha())){
                    String senha_n = String.valueOf(passwordField1.getPassword());
                    String senha_n_r = String.valueOf(passwordField2.getPassword());
                    if(senha_n.contains(senha_n_r)){
                        String novasenha = pw_encrypt.PW_Encrypt(senha_n);
                        userDAO.updateSenha(Oboject.getUsuario(), novasenha);
                        JOptionPane.showMessageDialog(null, "Senha trocada com sucesso.");
                        Oboject.setSenha(novasenha);
                        Senha_Antiga.setText("");
                        passwordField1.setText("");
                        passwordField2.setText("");
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "A senhas não coferem!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "A senha antiga não coferem!");
                }
            }
        });
    }
    public JPanel getTrocaSeha(){
        return this.trocaSenha;
    }
}
