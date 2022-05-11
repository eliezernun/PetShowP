import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) throws Exception {
       JFrame frame =  new JFrame("Teste");
        final JLabel label = new  JLabel("Teste A");
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
