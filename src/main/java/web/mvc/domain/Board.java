package web.mvc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;
    private String subject;
    private String writer;
    private String content;
}
