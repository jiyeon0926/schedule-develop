package shcedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shcedule.ResponseDto.UserResponseDto;
import shcedule.entity.User;
import shcedule.repository.UserRepository;

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
}
