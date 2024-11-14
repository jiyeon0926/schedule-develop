package shcedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shcedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
