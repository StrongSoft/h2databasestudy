package com.example.demo.board.Controller;

import com.example.demo.board.exception.ResourceNotFoundException;
import com.example.demo.board.model.Board;
import com.example.demo.board.model.Post;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.support.MessageSourceAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author leeseungmin on 2019-04-16
 */
@RestController
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;
    private MessageSourceAccessor messageSource;

    @Autowired
    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource){
        this.messageSource = new MessageSourceAccessor(messageSource);
    }

    @RequestMapping(value = "/{boardname}/info", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Board> info(@PathVariable String boardname) {
        return ResponseEntity.ok(boardService.findBoard(boardname));
    }

    @RequestMapping(value = "/{boardname}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Board> free(@PathVariable String boardname) {
        System.out.println(boardname);
        return ResponseEntity.ok(boardService.findBoard(boardname));
    }

    @RequestMapping(value = "/{boardname}/list", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<List<Post>> listPosts(@PathVariable String boardname) {
        return ResponseEntity.ok(boardService.findPosts(boardname));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> resourceNotFoundException(ResourceNotFoundException exception, Locale locale){
        System.out.println(exception.getError());
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", exception.getStatus());
        body.put("error", exception.getError());
        body.put("message", messageSource.getMessage(exception.getCode(), exception.getArgs(), locale).orElse("No message available"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}