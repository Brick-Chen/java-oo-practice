package com.twu;

import com.twu.role.Administrator;
import com.twu.role.User;

import java.util.Scanner;

public class Main {

    public static void userInteraction(User user, Scanner sc) {
        String userName = user.getName();

        while(true) {
            System.out.println(userName + ", " + "欢迎来到热搜系统, 请选择您要进行的操作：");
            System.out.println("1: 查看热搜排行榜");
            System.out.println("2: 给热搜事件投票");
            System.out.println("3: 购买热搜");
            System.out.println("4: 添加热搜");
            System.out.println("5. 若要退出，请输入字母\"q\"");

            String input = sc.nextLine();
            if (input.equals("1")) {
                user.viewTopSearch();
            }
            else if (input.equals("2")) {
                System.out.printf("请输入您要投票的热搜：(您当前拥有的票数为%d票)", user.getTicket());
                String voteName = sc.nextLine();
                System.out.println("请输入票数: ");
                String number = sc.nextLine();
                user.vote(voteName, Integer.parseInt(number));
            }
            else if (input.equals("3")) {
                System.out.println("请输入您要购买的热搜：");
                String voteName = sc.nextLine();
                System.out.println("请输入金额: ");
                String money = sc.nextLine();
                user.buySearchItem(voteName, Integer.parseInt(money));
            }
            else if (input.equals("4")) {
                System.out.println("请输入您要添加的热搜：");
                String name = sc.nextLine();
                user.addSearchItem(name);
            }
            else if (input.equalsIgnoreCase("q")) {
                break;
            }
            else {
                System.out.println("输入无效，请重新输入");
            }
        }
    }

    public static void adminInteraction(Administrator admin, Scanner sc) {
        String adminName = admin.getName();

        while (true) {
            System.out.println(adminName + ", " + "欢迎来到热搜系统, 请选择您要进行的操作：");
            System.out.println("1: 查看热搜排行榜");
            System.out.println("2: 添加热搜");
            System.out.println("3: 添加超级热搜");
            System.out.println("5. 若要退出，请输入字母\"q\"");

            String input = sc.nextLine();

            if (input.equals("1")) {
                admin.viewTopSearch();
            }
            else if (input.equals("2")) {
                System.out.println("请输入您要添加的热搜：");
                String name = sc.nextLine();
                admin.addSearchItem(name);
            }
            else if (input.equals("3")) {
                System.out.println("请输入您要添加的超级热搜：");
                String name = sc.nextLine();
                admin.addSuperSearchItem(name);
            }

            else if (input.equalsIgnoreCase("q")) {
                break;
            }
            else {
                System.out.println("输入无效，请重新输入");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("欢迎来到热搜系统，请选择你的使用者类型 (键盘输入数字\"1\"或者\"2\")：");
            System.out.println("1: 用户");
            System.out.println("2: 管理员");
            System.out.println("若要退出系统，请输入字母\"q\"");
//            System.out.println(" ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("请输入你的用户名：");
                String name = scanner.nextLine();
                if (name == null || name.length() == 0) {
                    System.out.println("用户名不能为空！");
                    System.out.println(" ");
                    continue;
                }
                System.out.println(" ");
                userInteraction(new User(name), scanner);
            }
            else if (input.equals("2")) {
                System.out.println("请输入管理员名称：");
                String name = scanner.nextLine();
                if (name == null || name.length() == 0) {
                    System.out.println("管理员名字不能为空！");
                    System.out.println(" ");
                    continue;
                }
                System.out.println(" ");
                adminInteraction(new Administrator(name), scanner);
            }
            else if (input.equalsIgnoreCase("q")) {
                break;
            }
            else {
                System.out.println("命令无效，请重新输入！");
                System.out.println(" ");
            }
        }
        scanner.close();
    }

}
