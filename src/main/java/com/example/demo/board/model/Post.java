package com.example.demo.board.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author leeseungmin on 2019-04-16
 */
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createdAt;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Board board;

    protected Post() {

    }

    protected Post(Board board, String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.createdAt = new Date();
        this.content = content;
        this.board = board;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", board=" + board +
                '}';
    }
}
