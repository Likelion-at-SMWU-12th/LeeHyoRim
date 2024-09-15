package study.querydsl.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    // 댓글은 하나의 게시판에 속함 (다대일 관계)
    @ManyToOne
    @JoinColumn(name = "board_id")
    @ToString.Exclude
    private Board board;

    // 댓글은 하나의 작성자에게 속함 (다대일 관계)
    @ManyToOne
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private Author author;

    public Comment(String content) {
        this.content = content;
    }
}
