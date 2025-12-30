package web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.mvc.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
