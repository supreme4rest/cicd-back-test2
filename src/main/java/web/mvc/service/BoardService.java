package web.mvc.service;

import web.mvc.domain.Board;

import java.util.List;

public interface BoardService {
    //전체 조회
    List<Board> selectAll();

    //글번호 조회
    Board selectByBno(Long bno);

    //게시글 등록
    void insert(Board board);

    //게시글 수정
    Board update(Board board);

    //게시글 삭제
    void delete(Long bno);
}
