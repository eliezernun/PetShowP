package UI;

import DAO.UserDAO;
import DTO.UserDTO;
import UTIL.PW_Encrypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_UI {

    private JTextField Login_Usuario;
    private JPasswordField Login_senha;
    private JButton cancelarButton;
    private JButton loginButton;

    public JPanel getLogin_form() {
        return login_form;
    }

    private JPanel login_form;

    public Login_UI(JFrame Janela) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario, senha;
                senha = String.valueOf(Login_senha.getPassword());
                usuario = Login_Usuario.getText();
                if(usuario.isEmpty() || usuario.isBlank()){
                    JOptionPane.showMessageDialog(null, "O campo 'Nome de usuario não pode estar vazio!'");
                    return;
                }
                if(senha.isBlank() || senha.isEmpty()){
                    JOptionPane.showMessageDialog(null, "O campo 'Senha não pode estar vazio!'");
                    return;
                }
                PW_Encrypt pw_encrypt = new PW_Encrypt();
                String SenhaC = pw_encrypt.PW_Encrypt(senha);
                UserDAO userLogin = new UserDAO();
                UserDTO userObject = userLogin.getUserPropsFromDB(usuario, SenhaC);

                if((userObject != null)){
                    menu(userObject);
                    Janela.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Falha na autenticação do usuario!");
                    return;
                }
            }
        });
    }
    public  static  void menu(UserDTO userObject){
        Menu MenuP = new Menu(userObject);
        JPanel Menu_ui = MenuP.getMenuPrincipal();
        JFrame Janela = new JFrame();
        Janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Janela.setContentPane(Menu_ui);
        Janela.pack();
        Janela.setSize(800,600);
        Janela.setLocationRelativeTo(null);
        Janela.setVisible(true);
        Janela.setTitle("PetShowP ->");

    }
}
