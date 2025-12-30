package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    ACCESS_DENIED(600, "로그인하고 이용해주세요!"),
    NOTFOUND_ID(601, "존재하지 않는 ID."),
    DUPLICATED_ID(602, "중복되는 ID."),
    WRONG_PASSWORD(603, "비밀번호 오류."),

    FAILED_DETAIL(604, "해당글 번호를 찾을 수 없습니다."),
    FAILED_UPDATE(605, "글번호를 찾을 수 없어서 수정 실패."),
    FAILED_DELETE(606, "글번호 오류로 인한 삭제 실패.");

    final private int status;
    final private String message;
}
