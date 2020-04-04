package example;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请填写用户名：");
        String name = sc.next();
        /**
         * 验证用户名
         * while循环控制直到输入合法为止
         */
        while(!checkName(name)) {
            System.out.println("用户名不合法，请重新输入：");
            name=sc.next();
        }

        /**
         * 验证密码
         */
        System.out.println("请填写密码：");
        String pwd = sc.next();

        while(!checkPwd(pwd)) {
            System.out.println("密码不合法，请重新输入：");
            pwd=sc.next();
        }
        System.out.println("注册成功！");
    }

    /**
     * 用户名验证
     * @param name
     * @return
     */
    public static boolean checkName(String name) {
        String regExp = "^[^0-9][\\w_]{5,9}$";
        if(name.matches(regExp)) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 密码验证
     * @param pwd
     * @return
     */
    public static boolean checkPwd(String pwd) {
        String regExp = "^[\\w_]{6,20}$";
        if(pwd.matches(regExp)) {
            return true;
        }
        return false;
    }
}
