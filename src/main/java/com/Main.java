package com;

import java.util.Scanner;

//scanner 객체를 이용해서 터미널 입력 받기
public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);

        int lastId = 0;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSayingContent = scanner.nextLine().trim();
                //메서드 체이닝

                System.out.print("작가 : ");
                String wiseSayingAuthor = scanner.nextLine().trim();

                int number = ++lastId;

                System.out.printf("%d번 명언이 등록되었습니다.",(number));
            }
        }

        scanner.close();
    }
}
