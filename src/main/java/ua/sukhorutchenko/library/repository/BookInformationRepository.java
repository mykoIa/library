package ua.sukhorutchenko.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sukhorutchenko.library.entity.BookInformation;

@Repository
public interface BookInformationRepository extends JpaRepository<BookInformation, Long> {
}
