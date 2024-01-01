import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class AppTiketBus extends AppTiketBusPanel {
    private JPanel AppTiketBusPanel;
    private JComboBox pilih;
    private JCheckBox vip;
    private JCheckBox ekonomi;
    private JCheckBox vvip;
    private JCheckBox executive;
    private JTextField noKursi;
    private JTextField namaPenum;
    private JTextField jumlahBel;
    private JTextField total;
    private JTextField uangB;
    private JTextField uangK;
    private JButton inputKembaliButton;
    private JButton cetakButton;
    private JButton keluarButton;
    private JTextArea data;
    private JTextField harga;
    private JLabel db_jurusan;
    private JLabel db_jenis;
    private JLabel db_harga;
    private JLabel db_noKursi;
    private JLabel db_namaPenum;
    private JLabel db_jumlahBel;
    private JLabel db_total;
    private JLabel db_uangB;
    private JLabel db_uangK;


    public AppTiketBus() {
        harga = new JTextField();
        jumlahBel = new JTextField();
        uangB = new JTextField();
        uangK = new JTextField();
        noKursi = new JTextField();
        namaPenum = new JTextField();
        total = new JTextField();
        pilih = new JComboBox<>(new String[]{"pilih jurusan", "Nusa Tenggara Barat", "Bali", "Banyuwangi", "Surabaya", "Jogja", "Jakarta"});
        vip = new JRadioButton("VIP");
        vvip = new JRadioButton("VVIP");
        ekonomi = new JRadioButton("Ekonomi");
        executive = new JRadioButton("Executive");
        inputKembaliButton = new JButton("Input Kembali");
        cetakButton = new JButton("Cetak");
        keluarButton = new JButton("Keluar");
        data = new JTextArea();

        // Tambahkan komponen ke panel
        add(new JLabel("Nomor Kursi"));
        add(noKursi);
        add(new JLabel("Nama Penumpang"));
        add(namaPenum);
        add(new JLabel("Jumlah Pembelian"));
        add(jumlahBel);
        add(new JLabel("Total Harga"));
        add(total);
        add(new JLabel("Uang Bayar"));
        add(uangB);
        add(new JLabel("Uang Kembali"));
        add(uangK);
        add(new JLabel("Pilih Jurusan"));
        add(pilih);
        add(new JLabel("Pilih Kelas"));
        add(vip);
        add(vvip);
        add(ekonomi);
        add(executive);
        add(inputKembaliButton);
        add(cetakButton);
        add(keluarButton);
        add(new JScrollPane(data));




        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(vip);
        buttonGroup.add(vvip);
        buttonGroup.add(ekonomi);
        buttonGroup.add(executive);


        inputKembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonGroup.clearSelection();
                harga.setText("");
                pilih.setSelectedItem("pilih jurusan");
                noKursi.setText("");
                namaPenum.setText("");
                total.setText("");
                jumlahBel.setText("");
                uangB.setText("");
                uangK.setText("");

            }
        });
        cetakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cetakButton.setText((String) pilih.getSelectedItem());
                data.setText(
                        "-----------Tiketing Bus-----------"+
                        "Nomor Kursi     : "+noKursi.getText()+
                        "Nama Penumpang  : "+namaPenum.getText()+
                        "Jumlah Pembelian: "+jumlahBel.getText()+
                        "Total Harga     : "+total.getText()+
                        "Uang Bayar      : "+uangB.getText()+
                        "Uang Kembali    : "+uangK.getText());
            }
        });
       keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog(null,"Anda Yakin Keluar?","Keluar",JOptionPane.OK_OPTION);
                if (answer == JOptionPane.OK_OPTION){
                    System.exit(0);
                }

            }
        });

        pilih.addActionListener(new ActionListener() {
            int vip,vvip,ekonomi,executive;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pilih.getSelectedItem().equals("pilih jurusan")){
                    buttonGroup.clearSelection();
                    harga.setText("");
                }
                else if (pilih.getSelectedItem().equals("Nusa Tenggara Barat")){
                     vip = 700000;
                     vvip = 1200000;
                     ekonomi = 400000;
                     executive = 650000;
                }
                else if (pilih.getSelectedItem().equals("Bali")){
                    vip = 700000;
                    vvip = 1200000;
                    ekonomi = 400000;
                    executive = 650000;
                }
                else if (pilih.getSelectedItem().equals("Banyuwangi")){
                    vip = 700000;
                    vvip = 1200000;
                    ekonomi = 400000;
                    executive = 650000;
                }
                else if (pilih.getSelectedItem().equals("Surabaya")){
                    vip = 700000;
                    vvip = 1200000;
                    ekonomi = 400000;
                    executive = 650000;
                }
                else if (pilih.getSelectedItem().equals("Jogja")){
                    vip = 700000;
                    vvip = 1200000;
                    ekonomi = 400000;
                    executive = 650000;
                }
                else if (pilih.getSelectedItem().equals("Jakarta")){
                    vip = 700000;
                    vvip = 1200000;
                    ekonomi = 400000;
                    executive = 650000;
                }

            }
        });
        vip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vip.isSelected()){
                    harga.setText(String.valueOf(vip));
                }

            }
        });
        vvip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vvip.isSelected()){
                    harga.setText(String.valueOf(vvip));
                }

            }
        });
        ekonomi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ekonomi.isSelected()){
                    harga.setText(String.valueOf(ekonomi));
                }

            }
        });
        executive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (executive.isSelected()){
                    harga.setText(String.valueOf(executive));
                }

            }
        });
//        noKursi.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        namaPenum.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
        jumlahBel.addActionListener(new ActionListener() {
            int t_harga,t_jumlahBel,t_total;
            @Override
            public void actionPerformed(ActionEvent e) {
                t_harga = Integer.parseInt(harga.getText());
                t_jumlahBel = Integer.parseInt(jumlahBel.getText());
                t_total = t_jumlahBel*t_harga;
                total.setText(String.valueOf(t_total));
            }
        });
        uangB.addActionListener(new ActionListener() {
            int t_uangK,t_bayar,t_total;
            @Override
            public void actionPerformed(ActionEvent e) {
                t_total = Integer.parseInt(total.getText());
                t_bayar = Integer.parseInt(uangB.getText());
                t_uangK = t_bayar-t_total;
                uangK.setText(String.valueOf(t_uangK));

            }
        });
        jumlahBel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int a,b,c;
                a = Integer.valueOf(uangB.getText());
                b = Integer.valueOf(total.getText());
                c = a-b;
                uangK.setText(""+c);
            }
        });
        uangB.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int a,b,c;
                a = Integer.valueOf(harga.getText());
                b = Integer.valueOf(jumlahBel.getText());
                c = a*b;
                total.setText(""+c);
            }
        });

    }

//    public static void main(String args[]) {
//        JFrame frame = new JFrame("Aplikasi Tiket Bus");
//        frame.setContentPane(new AppTiketBus().AppTiketBusPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }


}
