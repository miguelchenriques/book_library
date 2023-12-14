package com.miguel.book_library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidRequestBody extends RuntimeException{

    public InvalidRequestBody(String message) {
        super(message);
    }

}
