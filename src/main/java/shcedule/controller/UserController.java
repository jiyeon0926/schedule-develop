package shcedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shcedule.RequestDto.UserSaveRequestDto;
import shcedule.ResponseDto.UserResponseDto;
import shcedule.service.UserService;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> userSave(@RequestBody UserSaveRequestDto saveRequestDto) {
        UserResponseDto responseDto = userService.userSave(saveRequestDto.getName(), saveRequestDto.getEmail(), saveRequestDto.getPassword());

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
