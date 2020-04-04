package example;

/* * @author :
* * @功能:主要监测界面，显示温度，湿度，光照强度， * @代码逻辑主要为处理串口通信的代码 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainLayout extends JFrame{
    private static JFrame jf;
    private static JLabel jl;
    private static JButton bt_open;
    private static JButton bt_close;
    private static JButton bt_sysInfo;
    private static JButton bt_back;
    public mainLayout(){
        jf=new JFrame("i am the new JFrame");
        jf.setVisible(true);
        jf.setLocation(10, 10);
        jf.setBounds(10, 10, 100, 100);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   }
        public static void main(String[] args) {
        mainLayout ml=new mainLayout();
    }
}
