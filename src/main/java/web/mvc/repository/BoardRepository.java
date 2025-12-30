package web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.mvc.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
