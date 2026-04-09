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
            } else if (cmd.startsWith("삭제")) {
                actionDelete(cmd);
            } else if (cmd.startsWith("수정")) {
                actionModify(cmd);
            }
        }
        scanner.close();
    }

    void actionWrite() {
        System.out.print("명언 : ");
        String Content = scanner.nextLine().trim();
        //메서드 체이닝

        System.out.print("작가 : ");
        String Author = scanner.nextLine().trim();

        WiseSaying wiseSaying = write(Author, Content);

        System.out.printf("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));

    }

    WiseSaying write(String author, String content) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, author, content);

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        //for문을 이용해서 wiseSayings 리스트에 있는 요소들을 역순으로 출력
        //-1은 인덱스의 크기보다 -1만큼 작기때문에
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            {
                System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
            }
        }

    }

    void actionDelete(String cmd) {
        String[] cmdBits = cmd.split("=");

        if (cmdBits.length < 2 || cmdBits[1].isEmpty()) {
            System.out.println(" id를 입력해주세요");
            return;
        }
        int id = Integer.parseInt(cmdBits[1]);

        delete(id);

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

    void delete(int id) {
        WiseSaying wiseSaying = null;
        for (int i = 0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).getId() == id) {
                wiseSaying = wiseSayings.get(i);
            }
        }
        if (wiseSaying == null) {
            System.out.println("해당 아이디는 존재하지 않습니다.");
            return;
        }

        wiseSayings.remove(wiseSaying);
    }

    void actionModify(String cmd) {
        String[] cmdBits = cmd.split("=");

        if (cmdBits.length < 2 || cmdBits[1].isEmpty()) {
            System.out.println(" id를 입력해주세요");
            return;
        }
        int id = Integer.parseInt(cmdBits[1]);

        modify(id);

        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
    }

    void modify(int id){
        WiseSaying wiseSaying = null;
        for(int i = 0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).getId() == id) {
                wiseSaying = wiseSayings.get(i);
            }
        }
        if (wiseSaying == null) {
            System.out.println("%d번 아이디는 존재하지 않습니다.".formatted(id));
        }

        System.out.println("명언(기존): %s".formatted(wiseSaying.getContent()));
        System.out.print("명언: ");
        String content = scanner.nextLine().trim();
        wiseSaying.setContent(content);

        System.out.println("작가(기존): %s".formatted(wiseSaying.getAuthor()));
        System.out.print("작가: ");
        String author = scanner.nextLine().trim();
        wiseSaying.setAuthor(author);
    }
}
