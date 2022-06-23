
import UI.Login_UI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");

            Login();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao abrir a conexão de teste! \nO Sistema sera fechado!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Conexão com a internet indisponivel!" +
                    "\n Para o correto funcionamento do sistema, verifique sua conexão com a internet!");
            System.exit(0);
        }
    }

    public  static void Login(){

        JFrame Janela = new JFrame();
        Login_UI Login = new Login_UI(Janela);
        JPanel Login_ui = Login.getLogin_form();
        Janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Janela.setContentPane(Login_ui);
        Janela.pack();
        Janela.setSize(300,300);
        Janela.setLocationRelativeTo(null);
        Janela.setVisible(true);
        Janela.setTitle("PetShowP ->");

    }
}

