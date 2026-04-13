package com.domain.wiseSaying;

import java.time.LocalDateTime;

public class WiseSaying {
    //필드값들은 웬만하면 private로 접근을 제한하는게 일반적이다.
    private final int id;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public WiseSaying(int id, String content, String author) {
        LocalDateTime now = LocalDateTime.now();
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdDate = now;
        this.modifiedDate = now;
        //생성자를 통해서 초기화
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

