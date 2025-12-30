package web.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.mvc.domain.Member;
import web.mvc.dto.MemberLoginDTO;
import web.mvc.dto.MemberReqDTO;
import web.mvc.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {
    final private MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<String> register(@RequestBody MemberReqDTO memberReqDto) {
        memberService.register(memberReqDto);

        return ResponseEntity.ok().body("register success");
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<String> duplicateCheck(@PathVariable String id) {
        String result = memberService.duplicateCheck(id);

        return  ResponseEntity.ok().body(result);
    }

    @PostMapping("/login")
    //public ResponseEntity<?> login(@RequestBody MemberLoginDTO memberLoginDto) {
    public ResponseEntity<?> login(MemberLoginDTO memberLoginDto) {
        System.out.println("memberLoginDto = "+memberLoginDto);
        Member member = memberService.login(memberLoginDto);

        return ResponseEntity.ok().body(member);
    }

}
