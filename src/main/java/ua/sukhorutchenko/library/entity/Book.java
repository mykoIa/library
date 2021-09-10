package ua.sukhorutchenko.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "book_information_id")
    private BookInformation bookInformation;

    @ManyToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "book")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "author_l",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<Author> author;

    public Book(String name, List<Author> author, Publisher publisher, BookInformation bookInformation) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.bookInformation = bookInformation;
    }

}
