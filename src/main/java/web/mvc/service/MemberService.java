package web.mvc.service;

import web.mvc.domain.Member;
import web.mvc.dto.MemberLoginDTO;
import web.mvc.dto.MemberReqDTO;

public interface MemberService {
    //가입
    void register(MemberReqDTO memberReqDto);

    //id 중복체크
    String duplicateCheck(String id);

    //로그인
    Member login(MemberLoginDTO memberLoginDto);

}
