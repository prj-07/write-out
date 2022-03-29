package com.example.roughwork02;

public class UserHelperClass {

    String name,Date,Category,Article;

    public UserHelperClass() {
//empty constructor
    }

    public UserHelperClass(String name, String date, String category, String article) {
        this.name = name;
        this.Date = date;
        this.Category = category;
        this.Article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getTopic() {
        return Article;
    }

    public void setTopic(String article) {
        Article = article;
    }
}
