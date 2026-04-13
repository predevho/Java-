package com.domain.wiseSaying;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public List<WiseSaying> getWiseSayingList() {
        return this.wiseSayingRepository.getWiseSayingList();
    }

    public void delete(WiseSaying wiseSaying) {
        this.wiseSayingRepository.delete(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String author, String content) {
        this.wiseSayingRepository.modify(wiseSaying, author, content);
    }

    WiseSaying findById(int id) {
        return this.wiseSayingRepository.findById(id);
    }

    public WiseSaying write(String author, String content) {

        WiseSaying wiseSaying = this.wiseSayingRepository.write(author, content);

        return wiseSaying;

    }
}
