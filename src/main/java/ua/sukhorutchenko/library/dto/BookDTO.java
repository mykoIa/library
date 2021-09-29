package ua.sukhorutchenko.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookDTO {

    private Long id;

    private String name;

    private BookInformationDTO bookInformation;

    private PublisherDTO publisher;

    private List<AuthorDTO> author;

    public BookDTO(String name, List<AuthorDTO> author, PublisherDTO publisher, BookInformationDTO bookInformation) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.bookInformation = bookInformation;
    }

}
