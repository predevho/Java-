package com.domain.wiseSaying;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WiseSaying {
    //필드값들은 웬만하면 private로 접근을 제한하는게 일반적이다.
    private int id;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public WiseSaying(String content, String author) {
        LocalDateTime now = LocalDateTime.now();
        this.content = content;
        this.author = author;
        this.createdDate = now;
        this.modifiedDate = now;
        //생성자를 통해서 초기화
    }

    public boolean isNew() {
        return getId() == 0;
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

    public String getCreatedDate() {
        return createdDate.format(formatter);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModifiedDate() {
        return modifiedDate.format(formatter);
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

