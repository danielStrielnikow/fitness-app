package pl.fitness.userservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fitness.userservice.dto.RegisterRequest;
import pl.fitness.userservice.dto.UserResponse;
import pl.fitness.userservice.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfiles(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }

    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable String userId){
        return ResponseEntity.ok(userService.existByUserId(userId));
    }
}
