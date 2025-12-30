package web.mvc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Member {
    @Id
    private String id;
    private String password;
    private String name;
    private String addr;
    private int age;
}
