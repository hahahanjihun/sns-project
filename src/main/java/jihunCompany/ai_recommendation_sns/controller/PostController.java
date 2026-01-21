package jihunCompany.ai_recommendation_sns.controller;

import jihunCompany.ai_recommendation_sns.dto.PostCreateRequest;
import jihunCompany.ai_recommendation_sns.dto.UserRegisterRequest;
import jihunCompany.ai_recommendation_sns.service.PostService;
import jihunCompany.ai_recommendation_sns.service.UserActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final UserActionService userActionService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody PostCreateRequest req){
        return ResponseEntity.ok(
                postService.createPost(req.getUserId(), req.getContent())
        );
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Void> view(
            @PathVariable Long postId,
            @RequestParam Long userId
    ) {
        userActionService.ViewPost(userId, postId);
        return ResponseEntity.ok().build();
    }
}
