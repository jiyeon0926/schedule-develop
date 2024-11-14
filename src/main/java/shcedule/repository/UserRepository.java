package shcedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shcedule.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
