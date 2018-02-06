package com.example.shaimaaderbaz.newsapp.models;

/**
 * Created by Shaimaa Derbaz on 2/3/2018.
 */

public class News {
    String type;
    String sectionName ;
    String publicationDate;
    String author;
    String title;
    String webUrl;
    public News()
    {}

    public News(String type,  String sectionName,String publicationDate,String author,String title,  String webUrl) {
        this.type = type;
        this.webUrl = webUrl;
        this.author=author;
        this.title = title;
        this.publicationDate = publicationDate;
        this.sectionName = sectionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
