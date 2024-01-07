// M.Arif Rahman Hakim - 2200018180
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AppTiketBus {
    private JPanel panelsaya;
    private JPanel panelkamu;
    private JComboBox<String> pilih;
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
    public JPanel panelutama;


    private int vipPrice;
    private int vvipPrice;
    private int ekonomiPrice;
    private int executivePrice;


    public AppTiketBus() {
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
                cetakTiket();
            }
        });

        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApplication();
            }
        });

        pilih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHarga();
            }
        });

        vip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHargaText();
            }
        });

        vvip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHargaText();
            }
        });

        ekonomi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHargaText();
            }
        });

        executive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHargaText();
            }
        });

        jumlahBel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotal();
            }
        });

        jumlahBel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateTotal();
            }
        });

        uangB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUangKembali();
            }
        });

        uangB.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateUangKembali();
            }
        });
    }

    private void updateHarga() {
        String jurusan = pilih.getSelectedItem().toString();

        switch (jurusan) {
            case "Nusa Tenggara Barat":
                vipPrice = 700000;
                vvipPrice = 1200000;
                ekonomiPrice = 400000;
                executivePrice = 650000;
                break;
            case "Bali":
                vipPrice = 800000;
                vvipPrice = 1300000;
                ekonomiPrice = 450000;
                executivePrice = 700000;
                break;
            case "Banyuwangi":
                vipPrice = 750000;
                vvipPrice = 1250000;
                ekonomiPrice = 420000;
                executivePrice = 680000;
                break;
            case "Surabaya":
                vipPrice = 720000;
                vvipPrice = 1220000;
                ekonomiPrice = 410000;
                executivePrice = 660000;
                break;
            case "Jogja":
                vipPrice = 730000;
                vvipPrice = 1230000;
                ekonomiPrice = 415000;
                executivePrice = 670000;
                break;
            case "Jakarta":
                vipPrice = 740000;
                vvipPrice = 1240000;
                ekonomiPrice = 420000;
                executivePrice = 680000;
                break;
            default:
                vipPrice = 0;
                vvipPrice = 0;
                ekonomiPrice = 0;
                executivePrice = 0;
                break;
        }

        updateHargaText();
    }

    private void updateHargaText() {
        if (vip.isSelected()) {
            harga.setText(String.valueOf(vipPrice));
        } else if (vvip.isSelected()) {
            harga.setText(String.valueOf(vvipPrice));
        } else if (ekonomi.isSelected()) {
            harga.setText(String.valueOf(ekonomiPrice));
        } else if (executive.isSelected()) {
            harga.setText(String.valueOf(executivePrice));
        } else {
            harga.setText("");
        }
    }

    private void updateTotal() {
        try {
            int t_harga = Integer.parseInt(harga.getText());
            int t_jumlahBel = Integer.parseInt(jumlahBel.getText());
            int t_total = t_jumlahBel * t_harga;
            total.setText(String.valueOf(t_total));
        } catch (NumberFormatException ex) {
            total.setText("0");
        }
    }

    private void updateUangKembali() {
        try {
            int t_total = Integer.parseInt(total.getText());
            int t_bayar = Integer.parseInt(uangB.getText());
            int t_uangK = t_bayar - t_total;
            uangK.setText(String.valueOf(t_uangK));
        } catch (NumberFormatException ex) {
            uangK.setText("");
        }
    }

    private void cetakTiket() {
        data.setText(
                "----------- Tiketing Bus -----------\n" +
                        "Nomor Kursi     : " + noKursi.getText() + "\n" +
                        "Nama Penumpang  : " + namaPenum.getText() + "\n" +
                        "Jumlah Pembelian: " + jumlahBel.getText() + "\n" +
                        "Total Harga     : " + total.getText() + "\n" +
                        "Uang Bayar      : " + uangB.getText() + "\n" +
                        "Uang Kembali    : " + uangK.getText());
    }

    private void exitApplication() {
        int answer = JOptionPane.showConfirmDialog(null, "Anda Yakin Keluar?", "Keluar", JOptionPane.OK_OPTION);
        if (answer == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

}
