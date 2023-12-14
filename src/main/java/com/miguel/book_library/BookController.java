package com.miguel.book_library;

import com.miguel.book_library.entities.book.Book;
import com.miguel.book_library.entities.book.BookDetails;
import com.miguel.book_library.entities.book.BookResults;
import com.miguel.book_library.entities.review.IBookReviews;
import com.miguel.book_library.entities.review.Review;
import com.miguel.book_library.entities.review.ReviewEntity;
import com.miguel.book_library.repositories.BookRepository;
import com.miguel.book_library.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book")
    public BookResults book(@RequestParam(required = false) String title) {
        List<Book> books = bookRepository.listBooks(title);
        return new BookResults(books);
    }

    @GetMapping("/book/{id}")
    public BookDetails bookDetails(@PathVariable int id) {
        Book book = bookRepository.getBook(id);
        IBookReviews bookReviews = this.reviewRepository.getBookReviews(id);
        return new BookDetails(
                book.id(), book.title(), book.authors(), book.languages(), book.download_count(), bookReviews.getRating(), bookReviews.getReviews()
        );
    }

    @PostMapping("/book/{id}/review")
    public ResponseEntity<ReviewEntity> addReview(@PathVariable int id, @RequestBody Review review) {
        bookRepository.getBook(id);
        ReviewEntity reviewEntity = new ReviewEntity(id, review.rating(), review.comment());
        return ResponseEntity.status(HttpStatus.OK).body(this.reviewRepository.save(reviewEntity));
    }

}
