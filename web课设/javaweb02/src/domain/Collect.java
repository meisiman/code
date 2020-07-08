package domain;

/**
 * @author Mei Siman
 * @date 2019/12/13  20:54
 */
public class Collect {
    private int articleId;
    private int userId;

    public Collect() {
        super();
    }

    public Collect(int articleId, int userId) {
        this.userId = userId;
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
