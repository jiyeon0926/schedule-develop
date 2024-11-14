package shcedule.RequestDto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleUpdateRequestDto {

    @NotNull
    private final String title;

    @NotNull
    private final String contents;
}
