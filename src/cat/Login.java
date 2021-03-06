package cat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 大娟
 * @ClassName Login.java
 * @Description 登录类
 * @Param
 * @createTime 2020年3月28日16:19
 */

public class Login extends JFrame implements ActionListener {
    private JPanel pan = new JPanel();  //创建JPanel面板对象
    private static JFrame jf = new JFrame();
    private JLabel namelab = new JLabel("账    号");  //创建带文本“用户名”的标签
    private JLabel passlab = new JLabel("密    码");  //创建带文本“密    码”的标签
    private JTextField nametext = new JTextField();  //创建文本框（JTextField）对象
    private JPasswordField passtext = new JPasswordField();  //创建密码框（JPasswordField）对象
    private ButtonGroup bg1 = new ButtonGroup();
    private ButtonGroup bg2 = new ButtonGroup();

    String jrtext;

    //创建带文本的登录、注册和单选按钮
    private JButton login = new JButton("登录");
    public JButton register = new JButton("注册");
    public JRadioButton jr1 = new JRadioButton("用户");
    public JRadioButton jr2 = new JRadioButton("管理员");

    //定义无参构造方法
    public Login() {
        Font font = new Font("宋体", Font.BOLD, 12);  //创建Font对象，并初始化font的字体名，风格和大小
        super.setTitle("欢迎登录英雄联盟赛事票务管理系统");
        pan.setLayout(null);  //使该窗体（or面板）取消布局管理器设置
        namelab.setBounds(70, 30, 60, 30);
        nametext.setBounds(140, 30, 140, 30);
        passlab.setBounds(70, 80, 60, 30);
        passtext.setBounds(140, 80, 140, 30);
        jr1.setBounds(90, 120, 60, 30);
        jr2.setBounds(180, 120, 90, 30);
        login.setBounds(80, 180, 90, 20);
        register.setBounds(190, 180, 90, 20);


        pan.add(namelab);
        pan.add(nametext);
        pan.add(passlab);
        pan.add(passtext);
        pan.add(login);
        pan.add(register);
        pan.add(jr1);
        pan.add(jr2);

        bg1.add(jr1);
        bg1.add(jr2);

        login.setFont(font);
        register.setFont(font);
        jr1.setFont(font);
        jr2.setFont(font);

        login.addActionListener(this);
        register.addActionListener(this);
        jr1.addActionListener(this);
        jr2.addActionListener(this);

        jf.add(pan);//调用本类的方法
        jf.setSize(400, 300);
        jf.setVisible(true);

    }


    public static void main(String[] args) {
        new cat.Login();  //实例化一个Login对象
    }

    public static void closeThis() {
        jf.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jr1){
            jr1();
        }else if(e.getSource() == jr2){
            jr2();
        } else if(e.getSource() == login){
            login();
        }else if(e.getSource() == register){
            register();
        }
    }

    public void jr1(){
        jrtext = jr1.getText();
    }

    public void jr2(){
        jrtext = jr2.getText();
    }

    public void login(){
        if(jrtext == "用户") {
            Jdbc d = new Jdbc();
            String name = nametext.getText();//返回窗口悬浮的编辑框文本
            String password = passtext.getText();
            if(name.length() != 0&&password.length() != 0) {
                Boolean b1 = new Boolean(d.compare(name, password));
                if (b1 == true) {
                    //销毁当前页面
                    closeThis();
                    //打开一个新的页面
                    new HomePage();
                }

            }
        }else{
            Jdbc d1 = new Jdbc();
            String name = nametext.getText();//返回窗口悬浮的编辑框文本
            String password = passtext.getText();
            if(name.length() != 0&&password.length() != 0){
                Boolean b2 = new Boolean(d1.compare1(name, password));
                if(b2 == true){
                    //销毁当前页面
                    closeThis();
                    //打开一个新的页面
                    new HomePage2();
                }
            }
        }
    }

    public void register(){
        closeThis();
        new Register();
    }

}