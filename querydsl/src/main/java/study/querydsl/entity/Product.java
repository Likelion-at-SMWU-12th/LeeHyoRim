package study.querydsl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private int price;
    private int stock;
    private int popularity; //인기도 필드
    private LocalDateTime createdAt;

    public Product(String name, int price, int stock, int popularity) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.popularity = popularity;
    }
}
