package ua.sukhorutchenko.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookInformationDTO {

    private Long id;

    private String genre;

    private Long numberOfPages;

    public BookInformationDTO(String genre, Long numberOfPages) {
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

}
