package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
