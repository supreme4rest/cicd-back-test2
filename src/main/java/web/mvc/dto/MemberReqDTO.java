package web.mvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class MemberReqDTO {
    private String id;
    private String password;
    private String name;
    private String addr;
    private int age;
}