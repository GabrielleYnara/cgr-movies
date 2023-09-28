package repository;

import model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByUserId(Long userId);
}
