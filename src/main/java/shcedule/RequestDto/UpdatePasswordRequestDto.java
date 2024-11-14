package shcedule.RequestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePasswordRequestDto {

    @NotBlank
    private final String oldPassword;

    @NotBlank
    private final String newPassword;
}
