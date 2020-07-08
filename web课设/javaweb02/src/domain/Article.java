package domain;

/**
 * @author Mei Siman
 * @date 2019/11/26  19:46
 */
public class Article {
    private int id;
    private String title;
    private String author;
    private String context;

    public Article(){
        super();
    }

    public Article(int id, String title, String author, String context){
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.context = context;
    }

    public Article(String title, String author, String context){
        super();
        this.title = title;
        this.author = author;
        this.context = context;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
