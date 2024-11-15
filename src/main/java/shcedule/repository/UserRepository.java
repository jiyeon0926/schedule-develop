package shcedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import shcedule.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // id를 파라미터로 받아서 해당 유저가 존재하는지 판별
    default User findUserByUserIdOrElseThrow(Long userId) {
        return findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Please register as a user first."));
    }

    Optional<User> findByEmail(String email);

    // 수정일 내림차순으로 조회
    List<User> findAllByOrderByModifiedDateDesc();
}
