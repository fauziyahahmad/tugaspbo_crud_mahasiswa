
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HapusData extends JFrame{
    
    Statement statement;
    ResultSet resultSet;
    JButton btnDel, btnKembali;
    JLabel lJudul, lnim;
    JTextField tfnim;
    
    public HapusData(){
        
        lJudul= new JLabel("Hapus Data Mahasiswa");
        lnim = new JLabel("NIM");
        btnDel = new JButton("Hapus");        
        btnKembali = new JButton("Kembali");
        tfnim = new JTextField();
        
        setTitle("Hapus Data Mahasiswa");
        setSize(300,200);
        lJudul.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        setLayout(null);
        add(lJudul);
        add(lnim);
        add(tfnim);
        add(btnDel);
        add(btnKembali);
        
        lJudul.setBounds(50,10,150,25);
        lnim.setBounds(50,50,100,25);
        tfnim.setBounds(100,50,100,25);
        btnKembali.setBounds(30,90,100,25);
        btnDel.setBounds(140,90,100,25);
        
        btnKembali.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new formmhs();
            }
        });
        
        btnDel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBuatactionListener();
            }
        });
        
    }
    
    private void btnBuatactionListener(){
        
        KoneksiDB koneksi = new KoneksiDB();
                    try {
                        statement = koneksi.getKoneksi().createStatement();
                        statement.executeUpdate("DELETE FROM data_mhs WHERE nim='" + tfnim.getText() + "'");
                        JOptionPane.showMessageDialog(null, "Data berhasil di Hapus!","Hasil", JOptionPane.INFORMATION_MESSAGE);
                        statement.close();
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Driver tidak ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Data gagal di Hapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
                    }
        
    }
    
}
