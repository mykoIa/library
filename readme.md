# Library API

## Technologies
* Java 11
* PostgreSQL 10.16
* Spring Boot
* Spring Data JPA

## Description
#### The response is in JSON format
### Author
#### /api/library/author
/get - get all author \
/get/{id} - get author by id \
/delete/{id} - delete author by id \
/add/{name} - create new author \
/update/{id}&{name} - update author, {id} author which update, {name} new name

#### Example

/api/library/author/add/J. K. Rowling

```json
{
  "id":1,
  "fullName":"J. K. Rowling"
}
```

### Book Information
#### /api/library/bookInfo
/get - get all information about books \
/get/{id} - get info by id \
/delete/{id} - delete info by id \
/add/{genre}&{numberOfPages} - create new info \
/update/{id}&{genre}&{numberOfPages} - update information, {id} information which update, \
{genre} new genre, {numberOfPages} - new number of pages 

#### Example

/api/library/bookInfo/add/Fantasy&223

```json
{
  "id":1,
  "genre":"Fantasy",
  "numberOfPages":223
}
```
### Publisher
#### /api/library/publisher

/get - get all publisher\
/get/{id} - get publisher by id \
/delete/{id} - delete publisher by id \
/add/{name} - create new publisher \
/update/{id}&{name} - update publisher, {id} publisher which update, {name} new name of publisher

#### Example

/api/library/publisher/add/Bloomsbury (UK)

```json
   {
      "id":1,
      "publisherName":"Bloomsbury (UK)"
   }
```
### Book
#### /api/library/book

/get - get all books  \
/get/{id} - get book by id \
/delete/{id} - delete book by id \
/add/{name}&{author_id}&{publisher_id}&{infoId} - create new book \
/update/{book_id}&{name}&{author_id}&{publisher_id}&{infoId} - update book

#### Example

/api/library/book/add/Harry Potter and the Philosopher's Stone&1&1&1

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
