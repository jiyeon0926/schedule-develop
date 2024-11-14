package shcedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import shcedule.ResponseDto.ScheduleResponseDto;
import shcedule.entity.Schedule;
import shcedule.entity.User;
import shcedule.repository.ScheduleRepository;
import shcedule.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto scheduleSave(Long userId, String title, String contents) {
        User user = userRepository.findUserByUserIdOrElseThrow(userId);

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(user);
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule);
    }

    public ScheduleResponseDto findScheduleById(Long id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if (optionalSchedule.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Schedule schedule = optionalSchedule.get();

        return new ScheduleResponseDto(schedule);
    }

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules.stream()
                .map(schedule -> new ScheduleResponseDto(schedule))
                .collect(Collectors.toList());
    }

    public void scheduleDelete(Long id) {
        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);
        scheduleRepository.delete(schedule);
    }

    public ScheduleResponseDto scheduleUpdate(Long id, String title, String contents) {
        Optional<Schedule> byId = scheduleRepository.findById(id);

        if (byId.isPresent()) {
            Schedule schedule = byId.get();
            schedule.setTitle(title);
            schedule.setContents(contents);
            Schedule updatedSchedule = scheduleRepository.save(schedule);

            return new ScheduleResponseDto(updatedSchedule);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
    }
}
