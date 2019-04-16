package com.example.demo.board.exception;

import org.springframework.http.HttpStatus;

/**
 * @author leeseungmin on 2019-04-16
 */
public class BoardNotFoundException extends ResourceNotFoundException {
    private final String boardname;

    public BoardNotFoundException(String boardname) {
        this.boardname = boardname;
    }

    public String getBoardname() {
        return boardname;
    }

    @Override
    public String getError() {
        return "Board "+ HttpStatus.NOT_FOUND.getReasonPhrase();
    }

    @Override
    public Object[] getArgs() {
        return new Object[]{boardname};
    }
}
