package study.querydsl.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import study.querydsl.entity.Product;
import study.querydsl.entity.ProductDetail;

@SpringBootTest
public class ProductDetailRepositoryTest {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveAndReadTest() {
        Product product = new Product();
        product.setName("스프링부트 JPA");
        product.setPrice(5000);
        product.setStock(500);

        productRepository.save(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setDescription("스프링부트와 JPA를 함께보는 책!");

        productDetailRepository.save(productDetail);

        System.out.println("saveProduct :" + productDetailRepository.findById(
                productDetail.getId()).get().getProduct());

        System.out.println("saveProductDetail :" + productDetailRepository.findById(
                productDetail.getId()).get());
    }
}
