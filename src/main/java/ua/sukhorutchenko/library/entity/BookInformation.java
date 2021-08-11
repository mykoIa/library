package ua.sukhorutchenko.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "book_information")
public class BookInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre")
    private String genre;

    @Column(name = "number_of_pages")
    private Long numberOfPages;

    public BookInformation(String genre, Long numberOfPages) {
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

}
