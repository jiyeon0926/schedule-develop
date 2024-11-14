package shcedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shcedule.ResponseDto.ScheduleResponseDto;
import shcedule.entity.Schedule;
import shcedule.entity.User;
import shcedule.repository.ScheduleRepository;
import shcedule.repository.UserRepository;

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
}
