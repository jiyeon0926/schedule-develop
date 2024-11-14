package shcedule.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleSaveRequestDto {

    @NotNull
    private final Long userId;

    @NotBlank
    private final String title;

    @NotBlank
    private final String contents;
}
