package shcedule.RequestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSaveRequestDto {

    @NotBlank
    private final String name;

    @NotBlank
    private final String email;

    @NotBlank
    private final String password;
}
