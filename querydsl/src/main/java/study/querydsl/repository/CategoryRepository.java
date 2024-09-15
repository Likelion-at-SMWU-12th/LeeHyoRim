package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

public interface CategoryRepository extends JpaRepository<Locale.Category, Long> {
}
