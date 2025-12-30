package web.mvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class MemberLoginDTO {
    private String id;
    private String password;
}