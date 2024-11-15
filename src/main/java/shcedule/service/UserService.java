package shcedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import shcedule.ResponseDto.UserFindResponseDto;
import shcedule.ResponseDto.UserResponseDto;
import shcedule.config.PasswordEncoder;
import shcedule.entity.User;
import shcedule.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto userSave(String name, String email, String password) {
        // 비밀번호 암호화 후 저장
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(name, email, encodedPassword);
        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser);
    }

    public UserFindResponseDto findUserByUserId(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + userId);
        }

        User user = optionalUser.get();

        return new UserFindResponseDto(user);
    }

    public List<UserFindResponseDto> findAll() {
        List<User> users = userRepository.findAllByOrderByModifiedDateDesc();

        return users.stream()
                .map(user -> new UserFindResponseDto(user))
                .collect(Collectors.toList());
    }

    public void userDelete(Long userId) {
        User user = userRepository.findUserByUserIdOrElseThrow(userId);
        userRepository.delete(user);
    }

    public void updatePassword(Long userId, String oldPassword, String newPassword) {
        User user = userRepository.findUserByUserIdOrElseThrow(userId);

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password does not match.");
        }

        String encodedPassword = passwordEncoder.encode(newPassword);
        user.updatePassword(encodedPassword);
    }
}
