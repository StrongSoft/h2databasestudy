package com.example.demo.board.exception;

import org.springframework.http.HttpStatus;

/**
 * @author leeseungmin on 2019-04-16
 */
public abstract class ResourceNotFoundException extends RuntimeException{
    public HttpStatus getStatus(){
        return HttpStatus.NOT_FOUND;
    }

    public String getError(){
        return HttpStatus.NOT_FOUND.getReasonPhrase();
    }

    public String getCode(){
        return "error."+getClass().getSimpleName();
    }

    public Object[] getArgs(){
        return null;
    }
}
