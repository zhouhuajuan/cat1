package cat;

import example.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author 大娟
 * @version 1.0.0
 * @ClassName Jdbcs.java
 * @Description 数据库连接类
 * @Param
 * @createTime 2020年3月28号
 */

import javax.swing.JOptionPane;

public class Jdbc {
    Connection con = null;
    Statement statement = null;
    ResultSet res = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/cat?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true";
    String name = "root";
    String passwd =null;
    private Object String;

    public Jdbc() {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, name, passwd);
            statement = con.createStatement();

        } catch (ClassNotFoundException e) {
            System.out.println("对不起，找不到这个Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //用户注册功能的实现，添加数据
    public void insert(String username, String password) throws SQLException {
        if (username == null || username.trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "注册账号为空，请重新输入！");
            return;
        }

        // 编写sql语句
        String sql="select username from user where username='"+username+"' ";
        String sql1 = "insert into user(username,password) values(\"" + username + "\",\"" + password + "\")";
        // 执行sql语句
        ResultSet rs=statement.executeQuery(sql);
        if(rs.next()) {
            JOptionPane.showMessageDialog(null, "对不起该用户已存在！");
        }else {
            int a = statement.executeUpdate(sql1);
            con.close();
            statement.close();
            if (a == 1) {
                JOptionPane.showMessageDialog(null, "注册成功！");
                Register.closeThis();
                new HomePage();
            }
        }
    }

    //对用户信息的修改实际上就是对密码的修改
    public boolean update(String username, String password, String newpassword) {
        boolean judge = false;
        boolean s = compare(username, password);
        if (s) {
            String sql = "update user set password=\"" + newpassword + "\"where username=\"" + username + "\"";
            try {
                int a = statement.executeUpdate(sql);
                if (a == 1) {
                    JOptionPane.showMessageDialog(null, "密码修改成功！");
                    judge = true;
                }
                con.close();
                statement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "用户不存在！");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "修改失败");
        }
        return judge;
    }

    //对比用户名和密码是否匹配
    public boolean compare(String username, String password) {
        boolean m = false;
        String sql = "select password from user where username=\"" + username + "\"";
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(1);
                System.out.println(pa + " " + password);
                if (pa.equals(password)) {
                    m = true;
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户名不存在！");
            }
            res.close();
            con.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    //对比管理员名和密码是否匹配
    public boolean compare1(String managername, String password) {
        boolean m = false;
        String sql = "select password from manager where managername=\"" + managername + "\"";
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(1);
                System.out.println(pa + " " + password);
                if (pa.equals(password)) {
                    m = true;
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "管理员名不存在！");
            }
            res.close();
            con.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }


    //添加赛事信息
    public void insert1(String date, String against) throws SQLException {
        if (date == null || date.trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "添加赛事信息为空，请重新输入！");
            return;
        }

        // 编写sql语句
        String sql="select against from competition where against='"+against+"' ";
        String sql1 = "insert into competition(date ,against) values(\"" + date + "\",\"" + against + "\")";
        // 执行sql语句
        ResultSet rs=statement.executeQuery(sql);
        if(rs.next()) {
            JOptionPane.showMessageDialog(null, "对不起该赛事已存在！");
        }else {
            int a = statement.executeUpdate(sql1);
            con.close();
            statement.close();
            if (a == 1) {
                JOptionPane.showMessageDialog(null, "添加成功！");
                Add.closeThis();
                new HomePage2();
            }
        }
    }

    //修改赛事信息
    public boolean update(String date, String against) throws SQLException {
        boolean judge = false;
        String sql1 = "select date from competition where against =\"" + against +"\"";
        ResultSet rs=statement.executeQuery(sql1);
        if (rs.next()) {
            String sql = "update competition set date =\"" + date + "\"where against=\"" + against + "\"";
            try {
                int a = statement.executeUpdate(sql);
                if (a == 1) {
                    JOptionPane.showMessageDialog(null, "赛事修改成功！");
                    judge = true;
                    Revise.closeThis();
                    new HomePage2();
                }
                con.close();
                statement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "修改失败！");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "该赛事不存在！");
        }
        return judge;
    }

    //删除赛事信息
    public void delete(String date, String against) throws SQLException {
        String sql="select against from competition where against=\""+against+"\"   ";
        String sql1 = "delete from competition where against=\"" + against + "\"";
        ResultSet rs=statement.executeQuery(sql);
        if(rs.next()) {
            int a = statement.executeUpdate(sql1);
            con.close();
            statement.close();
            if (a == 1) {
                JOptionPane.showMessageDialog(null, "删除成功！");
                Delete.closeThis();
                new HomePage2();
            }
        }else{
                JOptionPane.showMessageDialog(null, "该赛事不存在！");
        }

    }

    //对比赛事信息是否匹配
    public boolean compare2(String date, String against) {
        boolean m = false;
        String sql = "select date from competition where against=\"" + against + "\"";
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(1);
                System.out.println(pa + " " + date);
                if (pa.equals(date)) {
                    m = true;
                } else {
                    JOptionPane.showMessageDialog(null, "日期错误！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "赛事不存在！");
            }
            res.close();
            con.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
}

