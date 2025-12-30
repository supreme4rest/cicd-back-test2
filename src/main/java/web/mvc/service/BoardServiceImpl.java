package web.mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.Board;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorCode;
import web.mvc.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {
    final private BoardRepository boardRepository;

    @Override
    public List<Board> selectAll() {
        List<Board> list = boardRepository.findAll();

        return list;
    }

    @Override
    public Board selectByBno(Long bno) {
        Board b = boardRepository.findById(bno).orElseThrow(() -> new BasicException(ErrorCode.FAILED_DETAIL));

        return b;
    }

    @Override
    public void insert(Board board) {
        boardRepository.save(board);
    }

    @Override
    public Board update(Board board) {
        Board b = boardRepository.findById(board.getBno()).orElseThrow(() -> new BasicException(ErrorCode.FAILED_UPDATE));

        b.setSubject(board.getSubject());
        b.setContent(board.getContent());

        return b;
    }

    @Override
    public void delete(Long bno) {
        Board b = boardRepository.findById(bno).orElseThrow(() -> new BasicException(ErrorCode.FAILED_DELETE));
//        boardRepository.deleteById(b.getBno());
        boardRepository.delete(b);
    }
}
