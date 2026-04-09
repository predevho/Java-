package com;

public class WiseSaying {
    //필드값들은 웬만하면 private로 접근을 제한하는게 일반적이다.
    private int id;
    private String content;
    private String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        //생성자를 통해서 초기화
    }

    public int getId() {
        return id;
    }


    public String getContent() {
        return content;
    }


    public String getAuthor() {
        return author;
    }

}

