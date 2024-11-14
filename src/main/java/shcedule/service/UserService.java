package shcedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import shcedule.ResponseDto.UserFindResponseDto;
import shcedule.ResponseDto.UserResponseDto;
import shcedule.entity.User;
import shcedule.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto userSave(String name, String email, String password) {
        User user = new User(name, email, password);
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
}
