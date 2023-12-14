package com.miguel.book_library.entities.review;

import com.miguel.book_library.exceptions.InvalidRequestBody;

public record Review(float rating, String comment) {

    public Review {
        if (rating < 0 || rating > 5) {
            throw new InvalidRequestBody("Rating should be between 0 and 5");
        }
    }

}
