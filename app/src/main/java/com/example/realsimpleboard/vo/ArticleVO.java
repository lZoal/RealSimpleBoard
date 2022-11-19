package com.example.realsimpleboard.vo;

public class ArticleVO {
    private int articleNo;
    private String subject;
    private String description;
    private String author;
    private String tag;



    public ArticleVO(int articleNo, String subject, String description, String author,String tag) {
        this.articleNo = articleNo;
        this.subject = subject;
        this.description = description;
        this.author = author;
        this.tag=tag;
    }

    public int getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(int articleNo) {
        this.articleNo = articleNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


}
