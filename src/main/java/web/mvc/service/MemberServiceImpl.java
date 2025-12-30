package web.mvc.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.Member;
import web.mvc.dto.MemberLoginDTO;
import web.mvc.dto.MemberReqDTO;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorCode;
import web.mvc.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final private MemberRepository memberRepository;
    final private ModelMapper modelMapper;

    @Override
    public void register(MemberReqDTO memberReqDto) {
        //id 중복체크
        Member m = memberRepository
                .findById(memberReqDto.getId())
                .orElse(null);
        if (m != null) {
            throw new BasicException(ErrorCode.DUPLICATED_ID);
        }
        // dto -> entity 변환 ( lib - ModelMapper)
        Member entity = modelMapper.map(memberReqDto, Member.class);

        memberRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public String duplicateCheck(String id) {
        Member m = memberRepository.findById(id).orElse(null);
        if(m == null) return "사용가능합니다.";
        else return "중복입니다.";
    }

    @Override
    public Member login(MemberLoginDTO memberLoginDto) {
        Member m = memberRepository
                .findById(memberLoginDto.getId())
                .orElseThrow(() -> new BasicException(ErrorCode.NOTFOUND_ID));
        if(!memberLoginDto.getPassword().equals(m.getPassword())) {
            throw new BasicException(ErrorCode.WRONG_PASSWORD);
        }

        return m;
    }
}
