
import UI.Menu;

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
            menu();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao abrir a conexão de teste! \nO Sistema sera fechado!");
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Conexão com a internet indisponivel!" +
                    "\n Para o correto funcionamento do sistema, verifique sua conexão com a internet!");
        }
    }
    public  static  void menu(){
        Menu MenuP = new Menu();
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

