package shcedule.RequestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSaveRequestDto {

    @NotBlank
    private final String name;

    @NotBlank
    private final String email;

    @NotBlank
    private final String password;
}
