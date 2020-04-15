
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class EditData extends JFrame{
    
    JLabel lNim,lNama,lAlamat,lJudul;
    JTextField tfnim,tfnama,tfalamat;
    JButton btnUpdate, btnKembali;
    Statement statement;
    ResultSet resultSet;
    
    public EditData(){
        
        lJudul= new JLabel("MASUKKAN NIM YANG AKAN DIUPDATE");
        lNim = new JLabel("NIM");
        lNama = new JLabel("Nama");        
        lAlamat = new JLabel("Alamat");
        
        tfnim = new JTextField();
        tfnama = new JTextField();
        tfalamat = new JTextField();
        
        btnUpdate = new JButton("Update");
        btnKembali = new JButton("Kembali");
        
        setTitle("Update Data Pegawai");
        setSize(300,370);
        lJudul.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        setLayout(null);
        add(lJudul);
        add(lNim);
        add(lNama);
        add(lAlamat);
        add(tfnim);
        add(tfnama);
        add(tfalamat);
        add(btnUpdate);
        add(btnKembali);
        
        lJudul.setBounds(0,10,300,25);
        lNim.setBounds(50, 50, 100, 25);
        lNama.setBounds(50, 90, 100, 25);
        lAlamat.setBounds(50, 210, 100, 25);
        tfnim.setBounds(100, 50, 100, 25);
        tfnama.setBounds(100, 90, 100, 25);
        tfalamat.setBounds(100, 210, 100, 25);
        btnKembali.setBounds(30, 290, 100, 25);
        btnUpdate.setBounds(140, 290, 100, 25);
        
        btnKembali.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new formmhs();
            }
        });
        
        btnUpdate.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateactionListener();
            }
        });
        
    }
    
    private void btnUpdateactionListener(){
        
        KoneksiDB koneksi = new KoneksiDB();
                    try {
                        statement = koneksi.getKoneksi().createStatement();
                        statement.executeUpdate("UPDATE data_mhs SET nama='" + tfnama.getText() + "'," + "alamat='"+
                                                tfalamat.getText() +"' WHERE nim='" + tfnim.getText() +"'");
                        JOptionPane.showMessageDialog(null, "Data berhasil di Update!","Hasil", JOptionPane.INFORMATION_MESSAGE);
                        statement.close();
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Driver tidak ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Data gagal di Update!", "Hasil", JOptionPane.ERROR_MESSAGE);
                    }
        
    }
    
    
}
