package com.domain.wiseSaying;

import com.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private final List<WiseSaying> wiseSayingList = new ArrayList<>();
    private int lastId = 0;

    public List<WiseSaying> getWiseSayingList() {
        return wiseSayingList;
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    void modify(WiseSaying wiseSaying, String author, String content) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    WiseSaying findById(int id) {
        return wiseSayingList.stream()
                .filter(ws -> ws.getId() == id)
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
                    return null;
                });
    }

    public WiseSaying write(String author, String content) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);

        wiseSayingList.add(wiseSaying);

        return wiseSaying;

    }
}
