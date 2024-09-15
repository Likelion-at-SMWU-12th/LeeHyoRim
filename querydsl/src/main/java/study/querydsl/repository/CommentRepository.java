package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
