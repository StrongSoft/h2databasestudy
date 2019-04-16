package com.example.demo.board.model;

import javax.validation.constraints.NotNull;

public class PostForm {

    @NotNull
    private String author;
    @NotNull
    private String title;
    @NotNull
    private String content;

    public PostForm(){}

    public PostForm(@NotNull String author, @NotNull String title, @NotNull String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
