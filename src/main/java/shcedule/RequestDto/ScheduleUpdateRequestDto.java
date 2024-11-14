package shcedule.RequestDto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@RequiredArgsConstructor
public class ScheduleUpdateRequestDto {

    @NotNull
    @Length(min = 1, max = 10)
    private final String title;

    @NotNull
    private final String contents;
}
