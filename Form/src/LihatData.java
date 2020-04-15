
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LihatData extends JFrame{
    String[] [] data = new String [500] [3]; //baris, kolom
    String[] kolom = {"NIM", "NAMA", "ALAMAT"}; //menamai kolom di atasnya, ga harus sama kayak di database
    JTable tabel;
    JButton btnBack;
    JScrollPane scrollPane;
    Statement statement;
    ResultSet resultSet;
    
    public void LihatDataa(){
        setTitle("Data Mahasiswa");
        
        btnBack = new JButton("Kembali");
        tabel = new JTable(data,kolom);
        scrollPane = new JScrollPane(tabel);
        
        setLayout(new FlowLayout());
        add(scrollPane);
        add(btnBack);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               setVisible(false);
               new formmhs();
            }
        });
        
        KoneksiDB koneksi = new KoneksiDB();        
        try{
            
            statement = koneksi.getKoneksi().createStatement();
            
            String sql = "SELECT * FROM data_mhs";
            resultSet = statement.executeQuery(sql);
            
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("nim"); //disesuaikan dg nama di database
                data[p][1] = resultSet.getString("nama");
                data[p][2] = resultSet.getString("alamat");
                p++;
            }
            statement.close();
        }
        
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan","hasil", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan","hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
}
