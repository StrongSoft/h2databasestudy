package com.example.demo.board.repository;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author leeseungmin on 2019-04-16
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByBoard(Board board);
}
