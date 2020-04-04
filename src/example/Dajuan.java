package example;

import javax.swing.*;

public class Dajuan {
    private JPanel pan = new JPanel();
    private JFrame jf = new JFrame("注册");
    private JLabel namelab = new JLabel("账号");
    private JTextField nametext = new JTextField();
    private JLabel passwordlab = new JLabel("密码");
    private JTextField passwordtext = new JTextField();

    public JButton register = new JButton("注册");

    public Dajuan(){
        pan.setLayout(null);
        namelab.setBounds(70, 30, 60, 30);
        nametext.setBounds(140, 30, 140, 30);
        passwordlab.setBounds(70, 80, 60, 30);
        passwordtext.setBounds(140, 80, 140, 30);
        register.setBounds(200, 220, 60, 30);

        pan.add(namelab);
        pan.add(nametext);
        pan.add(passwordlab);
        pan.add(passwordtext);
        pan.add(register);

        jf.add(pan);
        jf.setSize(400,300);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new Dajuan();
    }
}
