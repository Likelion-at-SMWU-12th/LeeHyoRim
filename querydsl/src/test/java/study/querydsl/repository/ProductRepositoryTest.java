package study.querydsl.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import study.querydsl.entity.Product;
import study.querydsl.entity.QProduct;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    EntityManager entityManager;

    @BeforeEach
    void setUp() {
        productRepository.save(new Product("펜", 1000, 100, 50));
        productRepository.save(new Product("연필", 500, 200, 30));
        productRepository.save(new Product("노트", 2000, 150, 80));
        productRepository.save(new Product("지우개", 300, 300, 20));
        productRepository.save(new Product("자", 700, 250, 90));
        productRepository.save(new Product("필통", 5000, 50, 70));
        productRepository.save(new Product("가방", 10000, 10, 100));
        productRepository.save(new Product("책", 15000, 15, 60));
        productRepository.save(new Product("공책", 800, 100, 40));
        productRepository.save(new Product("볼펜", 1200, 90, 35));
    }

    @Test
    void queryDslTest(){
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<Product> productList =
                query.selectFrom(qProduct)
                        .where(qProduct.name.eq("펜"))
                        .orderBy(qProduct.price.asc())
                        .fetch();

        for (Product product : productList) {
            System.out.println("----------------------");
            System.out.println("Product Number : " + product.getId());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println("----------------------");
        }
    }

    @Test
    void queryDslTest2(){
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("----------------------");
            System.out.println("Product Number : " + product);
            System.out.println("----------------------");
        }

        List<Tuple> tupleList = jpaQueryFactory
                .select(qProduct.name, qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Tuple product : tupleList) {
            System.out.println("----------------------");
            System.out.println("Product Name : " + product.get(qProduct.name));
            System.out.println("Product Price : " + product.get(qProduct.price));
            System.out.println("----------------------");

        }
    }

    @Test
    void popularityTest() {
        // JPAQueryFactory를 사용하여 EntityManager를 초기화
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        // 인기 있는 상품 상위 10개를 가져오는 쿼리 실행
        List<Product> popularProducts = jpaQueryFactory
                .selectFrom(qProduct)
                .orderBy(qProduct.popularity.desc())
                .limit(10)
                .fetch();

        // 출력
        System.out.println("-----------인기순-----------");
        popularProducts.forEach(product -> {
            System.out.println("----------------------");
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Popularity: " + product.getPopularity());
            System.out.println("----------------------");
        });
    }

    @Test
    void recentTest() {
        // JPAQueryFactory를 사용하여 EntityManager를 초기화
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        // 최근 등록된 상품 상위 10개를 가져오는 쿼리 실행
        List<Product> recentProducts = jpaQueryFactory
                .selectFrom(qProduct)
                .orderBy(qProduct.id.desc())
                .limit(10)
                .fetch();

        // 출력
        System.out.println("-----------시간순-----------");
        recentProducts.forEach(product -> {
            System.out.println("----------------------");
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product ID: " + product.getId());
            System.out.println("----------------------");
        });
    }

}