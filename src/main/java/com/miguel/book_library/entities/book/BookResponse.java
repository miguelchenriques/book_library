package com.miguel.book_library.entities.book;

import java.util.List;

public record BookResponse(int count, String next, String previous, List<Book> results) {
}
