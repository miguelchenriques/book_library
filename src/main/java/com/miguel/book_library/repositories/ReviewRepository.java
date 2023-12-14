package com.miguel.book_library.repositories;

import com.miguel.book_library.entities.review.IBookReviews;
import com.miguel.book_library.entities.review.ReviewEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "review", path = "review")
public interface ReviewRepository extends CrudRepository<ReviewEntity, Long> {

    @Query(value = "select coalesce(avg(rating), 0) as rating, coalesce(array_agg(comment), cast('{}' as text[])) as reviews from review where book=?1", nativeQuery = true)
    IBookReviews getBookReviews(int bookId);

}
