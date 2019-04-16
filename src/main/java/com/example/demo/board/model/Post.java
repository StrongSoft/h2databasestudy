package com.example.demo.board.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author leeseungmin on 2019-04-16
 */
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createdAt;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Board board;

    protected Post() {

    }

    protected Post(String author, String title, String content, Board board) {
        this.author = author;
        this.title = title;
        this.createdAt = new Date();
        this.content = content;
        this.board = board;
    }
}
