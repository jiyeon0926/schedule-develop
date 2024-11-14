package shcedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import shcedule.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findUserByUserIdOrElseThrow(Long userId) {
        return findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Please register as a user first."));
    }
}
