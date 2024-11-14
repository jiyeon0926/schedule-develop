package shcedule.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@RequiredArgsConstructor
public class ScheduleSaveRequestDto {

    @NotNull
    private final Long userId;

    @NotBlank
    @Length(min = 1, max = 10)
    private final String title;

    @NotBlank
    private final String contents;
}
