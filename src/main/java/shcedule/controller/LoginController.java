package shcedule.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shcedule.RequestDto.LoginRequestDto;
import shcedule.config.PasswordEncoder;
import shcedule.entity.User;
import shcedule.repository.UserRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequestDto requestDto, HttpSession session) {
        Optional<User> user = userRepository.findByEmail(requestDto.getEmail());

        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        // 인증되면 세션에 email 저장
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            session.setAttribute("email", email);

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
