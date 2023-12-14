package com.miguel.book_library.entities.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miguel.book_library.entities.Person;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(
        int id,
        String title,
        List<Person> authors,
        List<String> languages,
        int download_count
        ) {
}
