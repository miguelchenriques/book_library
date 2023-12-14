# Installation
To start the web service running on port 8080 and a postgres database run docker compose:
```shell
docker compose up
```

# Usage
## Search Books
`[GET] /book`

Returns a list of books, it receives an optional query parameter `title`
used to search for books.

## Get book details
`[GET] /book/{id}`

Returns a book entity, containing the same data as the search books plus the
average rating and a list of reviews

## Add a Review
`[POST] /book/{id}/review`

Adds a review to a book, the review is and entity with the following format:
```json
{
  "rating": 3.5,
  "comment": "This is the review text"
}
```
