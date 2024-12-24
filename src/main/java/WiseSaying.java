public class WiseSaying { // 명언 저장 클래스
    private int id;
    private String author;
    private String content;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

}