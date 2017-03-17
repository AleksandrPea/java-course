package com.apea.training.ecourse.homework4.task19;

import org.junit.Assert;
import org.junit.Test;

public class ArticleManagerTest {

    private ArticleManager articleManager = ArticleManager.getInstance();

    public ArticleManagerTest() {
        articleManager.createArticle("Heading1", "content1");
        articleManager.createArticle("Heading2", "content2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createArticleWithNullTest() {
        articleManager.createArticle(null, "content");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIsCommitedTest() {
        articleManager.checkIsCommited(articleManager.getArticle(0));
    }

    @Test
    public void getArticleForEditingWrongIdTest() {
        Assert.assertNull(articleManager.getArticleForEditing(500));
    }

    @Test
    public void getArticleForEditingTest() {
        Article copy = articleManager.getArticleForEditing(0);
        Assert.assertEquals("Heading1", copy.getHeading());
        Assert.assertEquals("content1", copy.getContent());
        Assert.assertNull(copy.getId());
    }

    @Test
    public void commitTest() {
        Article newArticle = articleManager.getArticleForEditing(0);
        articleManager.setHeading(newArticle, "new Heading1");
        Assert.assertTrue(articleManager.commit(newArticle, 0));
        Assert.assertSame(newArticle, articleManager.getArticle(0));
    }

    @Test
    public void commitWithWrongIdTest() {
        Article newArticle = articleManager.getArticleForEditing(0);
        articleManager.setHeading(newArticle, "new Heading1");
        Assert.assertFalse(articleManager.commit(newArticle, 555));
    }
}
