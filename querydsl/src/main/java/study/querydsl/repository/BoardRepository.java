package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
