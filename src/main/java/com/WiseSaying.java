package com;

public class WiseSaying {
    //필드값들은 웬만하면 private로 접근을 제한하는게 일반적이다.
    private final int id;
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

    public void setId(int id) {
        //id는 final로 선언되어 있기 때문에 setter가 필요없다.
        //setter는 보통 final이 아닌 필드에 대해서 만들어준다.
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
}

