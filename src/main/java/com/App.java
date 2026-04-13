package com;

import com.domain.system.SystemController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final List<WiseSaying> wiseSayingList = new ArrayList<>();
    private int lastId = 0;

    void run() {
        SystemController systemController = new SystemController();
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                case "종료" -> {
                    systemController.actionExit();
                    return;
                }
                case "등록" -> actionWrite();
                case "목록" -> actionList();
                case "삭제" -> actionDelete(rq);
                case "수정" -> actionModify(rq);
            }
        }
    }

    void actionWrite() {
        System.out.print("명언: ");
        String content = scanner.nextLine().trim();

        System.out.print("작가: ");
        String author = scanner.nextLine().trim();

        WiseSaying wiseSaying = write(author, content);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    WiseSaying write(String author, String content) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, author, content);

        wiseSayingList.add(wiseSaying);

        return wiseSaying;
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        IntStream.range(0, wiseSayingList.size())
                .map(i -> wiseSayingList.size() - 1 - i)
                .mapToObj(wiseSayingList::get)
                .forEach(
                        wiseSaying -> System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()))
                );
    }

    void actionDelete(Rq rq) {

        int id = rq.getParamAsInt("id", -1);

        WiseSaying wiseSaying = findById(id);

        if (id == -1) {
            System.out.println("숫자를 입력해주세요.");
            return;
        }

        if (wiseSaying == null) {
            return;
        }

        delete(wiseSaying);

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

    void delete(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    void actionModify(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("숫자를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();

        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        modify(wiseSaying, content, author);

        System.out.println("%d번 명언이 수정 되었습니다.".formatted(id));
    }

    void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    WiseSaying findById(int id) {
        return wiseSayingList.stream()
                .filter(ws -> ws.getId() == id)
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("해당 아이디는 존재하지 않습니다.");
                    return null;
                });
    }


}