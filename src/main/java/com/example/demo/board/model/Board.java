package com.example.demo.board.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author leeseungmin on 2019-04-16
 */
@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date creatdedAt;

    public Board(){

    }

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Date getCreatdedAt() {
        return creatdedAt;
    }
}
