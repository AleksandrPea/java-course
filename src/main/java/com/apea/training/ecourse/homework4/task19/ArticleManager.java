package com.apea.training.ecourse.homework4.task19;

import java.util.Map;
import java.util.HashMap;

public class ArticleManager {

    private static ArticleManager instance = new ArticleManager();

    public static ArticleManager getInstance() { return instance;}

    private ArticleManager() {}

    private Map<Long, Article> articlesMap = new HashMap<>();
    private long idCounter = 0;

    public Article createArticle(String heading, String content) {
        if (heading == null || content == null) {
            throw new IllegalArgumentException("No null args!");
        }
        Article createdArticle = new Article(idCounter, heading, content);
        articlesMap.put(idCounter++,createdArticle);
        return createdArticle;
    }

    public Article getArticle(long id) {
        return articlesMap.get(id);
    }

    public Article getArticleForEditing(long id) {
        Article article = articlesMap.get(id);
        if (article == null) {
            return null;
        }
        return (Article)article.clone();
    }

    public boolean isCommited(Article article) {
        return article.getId() != null;
    }

    /** Commits article if another article with 'id' exists */
    public boolean commit(Article article, long id) {
        checkIsCommited(article);
        Article oldArticle = articlesMap.get(id);
        boolean exists = oldArticle != null;
        if (exists) {
            articlesMap.put(id, article);
            article.setId(id);
        }
        return exists;
    }

    public void setHeading(Article article, String heading) {
        checkIsCommited(article);
        article.setHeading(heading);
    }

    public void setContent(Article article, String content) {
        checkIsCommited(article);
        article.setContent(content);
    }

    void checkIsCommited(Article article) {
        if (isCommited(article)) {
            throw new IllegalArgumentException("Cannot commit or modify already commited article.");
        }
    }
}
