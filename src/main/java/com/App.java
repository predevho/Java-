package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//scanner 객체를 이용해서 터미널 입력 받기
public class App {
    Scanner scanner = new Scanner(System.in);
    //while문안에 넣으면 끝날때 초기화가 되므로 밖에다가 선언
    int lastId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    //메서드를 세분화하기 위해서 필드값으로 올림

    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }

        scanner.close();
    }
    void actionWrite(){
        System.out.print("명언 : ");
        String wiseSayingContent = scanner.nextLine().trim();
        //메서드 체이닝

        System.out.print("작가 : ");
        String wiseSayingAuthor = scanner.nextLine().trim();

        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying();

        wiseSaying.id = id;
        wiseSaying.content = wiseSayingContent;
        wiseSaying.author = wiseSayingAuthor;

        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.", (id));

    }
    void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        //for문을 이용해서 wiseSayings 리스트에 있는 요소들을 역순으로 출력
        //-1은 인덱스의 크기보다 -1만큼 작기때문에
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            {
                if (wiseSaying == null) {
                    continue;
                }
                System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.content, wiseSaying.author));
            }
        }

    }

}
