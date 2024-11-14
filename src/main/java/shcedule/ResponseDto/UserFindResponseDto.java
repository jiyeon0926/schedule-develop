package shcedule.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shcedule.entity.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@AllArgsConstructor
public class UserFindResponseDto {

    private final Long userId;
    private final String name;
    private final String email;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public UserFindResponseDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdDate = convertToDateTime(user.getCreatedDate());
        this.modifiedDate = convertToDateTime(user.getModifiedDate());
    }

    private LocalDateTime convertToDateTime(Long unixTimestamp) {
        Instant timestamp = Instant.ofEpochMilli(unixTimestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());

        return  localDateTime;
    }
}
