package pl.fitness.userservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fitness.userservice.dto.RegisterRequest;
import pl.fitness.userservice.dto.UserResponse;
import pl.fitness.userservice.model.User;
import pl.fitness.userservice.repo.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public UserResponse getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        return getUserResponse(user);
    }

    public UserResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exist");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedUser =  userRepository.save(user);

        return getUserResponse(savedUser);
    }
    private UserResponse getUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreateAt(user.getCreateAt());
        userResponse.setUpdateAt(user.getUpdateAt());

        return userResponse;
    }
}
