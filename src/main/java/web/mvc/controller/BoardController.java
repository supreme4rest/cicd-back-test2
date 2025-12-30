package web.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.mvc.domain.Board;
import web.mvc.service.BoardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<Object> selectAll() {
        List<Board> list = boardService.selectAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/boards/{bno}")
    public ResponseEntity<Board> selectByBno(@PathVariable Long bno) {
        Board b = boardService.selectByBno(bno);

        return ResponseEntity.ok().body(b);
    }

    @PostMapping("/boards")
    public ResponseEntity<String> insert(@RequestBody Board board) {
        boardService.insert(board);

        return ResponseEntity.ok().body("insert success");
    }

    @PutMapping("/boards/{bno}")
    public ResponseEntity<String> update(@PathVariable Long bno, @RequestBody Board board) {
        board.setBno(bno);
        boardService.update(board);

        return ResponseEntity.ok().body("update success");
    }

    @DeleteMapping("/boards/{bno}")
    public ResponseEntity<String> delete(@PathVariable Long bno) {
        boardService.delete(bno);

        return ResponseEntity.ok().body("delete success");
    }
}
