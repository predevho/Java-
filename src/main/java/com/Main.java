package com;

import java.util.Scanner;
//scanner 객체를 이용해서 터미널 입력 받기
public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

    scanner.close();
    }
}
