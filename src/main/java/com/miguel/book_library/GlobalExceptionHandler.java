package com.miguel.book_library;

import com.miguel.book_library.exceptions.InvalidRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    record ErrorResponse(String error) {
    }

    @ExceptionHandler(InvalidRequestBody.class)
    public ResponseEntity<ErrorResponse> handleInvalidReviewException(InvalidRequestBody ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<ErrorResponse> handleHttpStatusCodeException(HttpStatusCodeException ex) {
        if (ex.getStatusCode() == HttpStatus.NOT_FOUND)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Book not found"));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(""));
    }

}
