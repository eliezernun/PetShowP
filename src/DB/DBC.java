package DB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
    public Connection conectarDB(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://blzqyshvv53jjulhyzal-mysql.services.clever-cloud.com:3306";
            conn = DriverManager.getConnection(url, "u8zgt2tqx9fhhlwp", "u8zgt2tqx9fhhlwp");

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        return conn;
    }

}
