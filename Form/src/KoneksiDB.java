
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class KoneksiDB {
    public Connection getKoneksi() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost/mahasiswa";
        Connection con = DriverManager.getConnection(url, "root", ""); //db,un pw db
        
        return con;
    }
}
