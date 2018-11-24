package com.example.adonis.stackice.Model;

import java.util.List;

public class Item
{
    public String title;
    //public String pubDate;
    public String link;
    public String author;
    public String thumbnail;
    public String description;
    public List<String> categories;

    public Item(String title, String pubDate, String link, String author, String thumbnail, String description, List<String> categories) {
        this.title = title;
       // this.pubDate = pubDate;
        this.link = link;

        this.author = author;
        this.thumbnail = thumbnail;
        this.description = description;

        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}