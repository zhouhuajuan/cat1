package cat;

import example.Dajuan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Register implements ActionListener {
    private JPanel pan = new JPanel();
    private static JFrame jf = new JFrame("注册");
    private JLabel namelab = new JLabel("账号");
    private JTextField nametext = new JTextField();
    private JLabel passwordlab = new JLabel("密码");
    private JTextField passwordtext = new JTextField();

    public JButton register = new JButton("注册");

    public Register(){
        pan.setLayout(null);
        namelab.setBounds(70, 30, 60, 30);
        nametext.setBounds(140, 30, 140, 30);
        passwordlab.setBounds(70, 80, 60, 30);
        passwordtext.setBounds(140, 80, 140, 30);
        register.setBounds(170, 200, 60, 30);

        pan.add(namelab);
        pan.add(nametext);
        pan.add(passwordlab);
        pan.add(passwordtext);
        pan.add(register);

        register.addActionListener(this);

        jf.add(pan);
        jf.setSize(400,300);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new Register();
    }

    public static void closeThis() {
        jf.dispose();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        Jdbc d = new Jdbc();
        String username = nametext.getText();
        String password = passwordtext.getText();
        try {
            d.insert(username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}