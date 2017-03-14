package com.apea.training.ecourse.homework4.task19;

import java.util.HashMap;

public class ArticleManager {

    private HashMap<String, Article> articlesMap;
    private static ArticleManager instance = new ArticleManager();
    private static int idCounter = 0;
    private ArticleManager() {}

    public ArticleManager getInstance() { return instance;}

    public Article createArticle(String heading, String content) {
        if (heading == null || content == null) {
            throw new IllegalArgumentException("No null args!");
        }
        return new Article(""+idCounter++, heading, content);
    }
}
