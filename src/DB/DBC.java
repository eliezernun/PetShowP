package DB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
    public Connection conectarDB(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://u8zgt2tqx9fhhlwp:bPZ9T812MlDlFC3djFyn@hv-mtl2-013.clvrcld.net:14673/bl1ggqr9xp1cejlpgfc5?user=u8zgt2tqx9fhhlwp&password=bPZ9T812MlDlFC3djFyn";
            conn = DriverManager.getConnection(url);

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        return conn;
    }

}
