package com.back;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    int lastNo = 0;

    WiseSaying[] wiseSayings = new WiseSaying[10];
    int lasId = -1;

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.equals("삭제?id=1")) {
                actionDelete();
            } else if (cmd.equals("종료")) {
                break;
            }
        }
    }

    private void actionDelete() {
        delete();
        System.out.println("1번 명언이 삭제되었습니다.");
    }

    private void delete() {
        int deleteTargetIndex = -1;

        for (int i = 0; i < lasId; i++) {
            if (wiseSayings[i].id == 1) {
                deleteTargetIndex = i;
            }
        }
        for (int i = deleteTargetIndex; i < lasId; i++) {
            wiseSayings[i] = wiseSayings[i + 1];
        }
        lasId--;
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        WiseSaying[] foundedwiseSayings = findList();

        for (WiseSaying wiseSaying : foundedwiseSayings) {
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }
    }

    private WiseSaying[] findList() {

        WiseSaying[] foundedWiseSayings = new WiseSaying[lasId + 1];
        int foundedWiseSayingIndex = -1;

        for (int i = lasId; i >= 0; i--) {
            WiseSaying foundedWiseSaying = wiseSayings[i];
            foundedWiseSayings[++foundedWiseSayingIndex] = foundedWiseSaying;
        }
        return foundedWiseSayings;
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastNo));

    }

    private void write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying();

        wiseSaying.id = ++lastNo;
        wiseSaying.content = content;
        wiseSaying.author = author;

        wiseSayings[++lasId] = wiseSaying;

    }
}
