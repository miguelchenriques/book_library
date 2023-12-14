package com.miguel.book_library.repositories;

import com.miguel.book_library.entities.book.Book;
import com.miguel.book_library.entities.book.BookResponse;
import jakarta.annotation.Nullable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class BookRepository {

    private final RestTemplate restTemplate;
    private static final String api = "https://gutendex.com";

    public BookRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Book> listBooks(@Nullable String title) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(api + "/books");
        if (title != null)
            builder = builder.queryParam("search", title);
        String url = builder.build()
                .toUriString();

        BookResponse bookResponse = restTemplate.getForObject(url, BookResponse.class);
        return bookResponse.results();
    }

    public Book getBook(int id) {
        return restTemplate.getForObject(api + "/books/" + id, Book.class);
    }

}
