package shcedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shcedule.RequestDto.UserSaveRequestDto;
import shcedule.ResponseDto.UserFindResponseDto;
import shcedule.ResponseDto.UserResponseDto;
import shcedule.service.UserService;

import java.util.List;

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

    @GetMapping("/{userId}")
    public ResponseEntity<UserFindResponseDto> findUserByUserId(@PathVariable Long userId) {
        UserFindResponseDto responseDto = userService.findUserByUserId(userId);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping
    public List<UserFindResponseDto> findAll() {

        return userService.findAll();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> userDelete(@PathVariable Long userId) {
        userService.userDelete(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
