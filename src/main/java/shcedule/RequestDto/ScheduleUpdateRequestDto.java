package shcedule.RequestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleUpdateRequestDto {

    @NotNull
    private final String title;

    @NotNull
    private final String contents;
}
