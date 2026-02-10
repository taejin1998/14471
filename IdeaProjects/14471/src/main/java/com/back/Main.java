package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lastid = 0;
        WiseSaying[] wiseSayings = new WiseSaying[10];
        int lastWiseSayingIndex = -1;

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                WiseSaying wiseSaying = new WiseSaying();

                wiseSaying.id = ++lastid;
                wiseSaying.content = content;
                wiseSaying.author = author;

                wiseSayings[++lastWiseSayingIndex] = wiseSaying;
                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastid));

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = lastWiseSayingIndex; i >= 0; i--) {
                    WiseSaying foundedWiseSaying = wiseSayings[i];
                    System.out.println("%d / %s / %s".formatted(foundedWiseSaying.id, foundedWiseSaying.author, foundedWiseSaying.content));
                }
            } else if (cmd.equals("종료")) {
                break;
            }
        }
    }
}
