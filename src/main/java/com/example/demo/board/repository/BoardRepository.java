package com.example.demo.board.repository;

import com.example.demo.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leeseungmin on 2019-04-16
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByName(String name);
}
