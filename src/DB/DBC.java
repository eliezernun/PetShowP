package DB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
    public Connection conectarDB(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://blzqyshvv53jjulhyzal-mysql.services.clever-cloud.com:3306/blzqyshvv53jjulhyzal?user=u8zgt2tqx9fhhlwp&password=bPZ9T812MlDlFC3djFyn";
            conn = DriverManager.getConnection(url);

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        return conn;
    }

}
