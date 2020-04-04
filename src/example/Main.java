package example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.WeakHashMap;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;


public class Main extends JFrame{
    private static final int GAME_WIDTH = 1100;
    private static final int GAME_HEIGTH = 600;
    /**
     * 构造方法
     */
    public Main() {
        setTitle("主界面");
        setSize(GAME_WIDTH, GAME_HEIGTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.darkGray);
        setLocationRelativeTo(null);// 居中显示
        // }
    }
}
