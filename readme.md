# Library API

## Technologies
* Java 11
* PostgreSQL 10.16
* Spring Boot
* Spring Data JPA

## Description
#### The response is in JSON format
You can use swagger for test http://localhost:8080/api/library/swagger-ui.html
### Author
#### /api/library/author
/getAll - get all author \
/get - get author by id \
/delete - delete author by id \
/add - create new author \
/update - update author, {id} author which update, {name} new name

#### Example

curl -X POST "http://localhost:8080/api/library/author/add" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"fullName\": \"J. K. Rowling\"}"

```json
{
  "id":1,
  "fullName":"J. K. Rowling"
}
```

### Book Information
#### /api/library/bookInfo
/getAll - get all information about books \
/get - get info by id \
/delete - delete info by id \
/add - create new info \
/update - update information, {id} information which update, \
{genre} new genre, {numberOfPages} - new number of pages 

#### Example

curl -X POST "http://localhost:8080/api/library/bookInfo/add" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"genre\": \"Fantasy\", \"numberOfPages\": 223}"

```json
{
  "id":1,
  "genre":"Fantasy",
  "numberOfPages":223
}
```
### Publisher
#### /api/library/publisher

/getAll - get all publisher\
/get - get publisher by id \
/delete - delete publisher by id \
/add - create new publisher \
/update - update publisher, {id} publisher which update, {name} new name of publisher

#### Example

curl -X POST "http://localhost:8080/api/library/publisher/add" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"publisherName\": \"Bloomsbury (UK)\"}"

```json
   {
      "id":1,
      "publisherName":"Bloomsbury (UK)"
   }
```
### Book
#### /api/library/book

/getAll - get all books  \
/get - get book by id \
/delete - delete book by id \
/add - create new book \
/update - update book 

#### Example

curl -X POST "http://localhost:8080/api/library/book/add" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"author\": { \"id\": 1 }, \"bookInformation\": { \"id\": 1 }, \"name\": \"Harry Potter and the Philosopher's Stone\", \"publisher\": { \"id\": 1 }}"

```json
{
  "id":1,
  "name":"Harry Potter and the Philosopher's Stone",
  "bookInformation":{
    "id":1,
    "genre":"Fantasy",
    "numberOfPages":223
  },
  "publisher":{
    "id":1,
    "publisherName":"Bloomsbury (UK)"
  },
  "author":{
    "id":1,
    "fullName":"J. K. Rowling"
  }
}
```
