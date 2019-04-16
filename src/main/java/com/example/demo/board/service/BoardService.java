package com.example.demo.board.service;

import com.example.demo.board.exception.BoardNotFoundException;
import com.example.demo.board.model.Board;
import com.example.demo.board.model.Post;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author leeseungmin on 2019-04-16
 */
@Service
@Transactional
public class BoardService {
    private BoardRepository boardRepository;
    private PostRepository postRepository;

    @Autowired
    public void setBoardRepository(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Autowired
    public void setPostRepository(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Board findBoard(String boardname){
        Board board = boardRepository.findByName(boardname);
        if(Objects.isNull(board)){
            throw new BoardNotFoundException(boardname);
        }
        return board;
    }

    public List<Post> findPosts(String boardname){
        Board board   = findBoard(boardname);
        return postRepository.findByBoard(board);
    }

    private Optional<Post> setPost(long postId){
        Optional<Post> post = postRepository.findById(postId);
        return post;
    }
}
