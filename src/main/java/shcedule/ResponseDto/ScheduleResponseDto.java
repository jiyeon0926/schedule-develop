package shcedule.ResponseDto;

import lombok.Getter;
import shcedule.entity.Schedule;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final Long userId;
    private final String title;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.userId = schedule.getUser().getUserId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createdDate = convertToDateTime(schedule.getCreatedDate());
        this.modifiedDate = convertToDateTime(schedule.getModifiedDate());
    }

    private LocalDateTime convertToDateTime(Long unixTimestamp) {
        Instant timestamp = Instant.ofEpochMilli(unixTimestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());

        return  localDateTime;
    }
}
