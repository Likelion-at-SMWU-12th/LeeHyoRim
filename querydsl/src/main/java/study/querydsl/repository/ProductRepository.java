package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // 기본 crud는 있음, 필요한 경우 커스텀 메서드 추가

}
