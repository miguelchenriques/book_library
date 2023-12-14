package com.miguel.book_library.entities.book;

import com.miguel.book_library.entities.Person;

import java.util.List;

public record BookDetails(int id,
                          String title,
                          List<Person> authors,
                          List<String> languages,
                          int download_count,
                          float rating,
                          List<String> reviews) {
}
