package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                sc.nextLine();
                System.out.print("작가 : ");
                sc.nextLine();
            } else if (cmd.equals("종료")) {
                break;
            }
        }
    }
}
