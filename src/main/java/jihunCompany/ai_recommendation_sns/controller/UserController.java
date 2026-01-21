package jihunCompany.ai_recommendation_sns.controller;

import jihunCompany.ai_recommendation_sns.dto.UserRegisterRequest;
import jihunCompany.ai_recommendation_sns.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Long> register(@RequestBody UserRegisterRequest req) {
        return ResponseEntity.ok(
                userService.register(req.getUsername(), req.getPassword())
        );
    }
}
