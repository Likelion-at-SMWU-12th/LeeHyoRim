package com.example.server.dto;

public class Tweet {

    private String id;
    private String content;
    private String author;

    public Tweet(){}

    public Tweet(String id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String Id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String email) { this.content = content; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
