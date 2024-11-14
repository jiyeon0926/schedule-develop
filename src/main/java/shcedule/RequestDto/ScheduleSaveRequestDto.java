package shcedule.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleSaveRequestDto {

    @NotNull
    private final Long userId;

    @NotBlank
    private final String title;

    @NotBlank
    private final String contents;
}
