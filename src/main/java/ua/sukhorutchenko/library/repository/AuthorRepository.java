package ua.sukhorutchenko.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sukhorutchenko.library.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}