package ua.sukhorutchenko.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.entity.Publisher;

@Data
@NoArgsConstructor
public class BookDTO {

    private Long id;

    private String name;

    private BookInformation bookInformation;

    private Publisher publisher;

    private Author author;

    public BookDTO(String name, Author author, Publisher publisher, BookInformation bookInformation) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.bookInformation = bookInformation;
    }

}
