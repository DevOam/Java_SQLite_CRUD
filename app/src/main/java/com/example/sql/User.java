package com.example.sql;

public class User {
    private static int counter = 0;
    private int id;
    private String title;
    private String body;

    public User() {
        this.id = counter++;
    }

    public User(String title, String body) {
        this.id = counter++;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}


