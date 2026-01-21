package jihunCompany.ai_recommendation_sns.controller;

import jihunCompany.ai_recommendation_sns.dto.ActionRequest;
import jihunCompany.ai_recommendation_sns.service.UserActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actions")
public class UserActionController {

    private final UserActionService userActionService;

    @PostMapping("/like")
    public ResponseEntity<Void> like(@RequestBody ActionRequest req){
        userActionService.LikePost(req.getUserId(), req.getPostId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/view")
    @Deprecated //이 기능은 곧 사라질 예정이니 사용을 권장하지 않음
    public ResponseEntity<Void> view(@RequestBody ActionRequest req){
        throw new UnsupportedOperationException(
                "VIEW는 GET /posts/{postId}에서 처리됩니다."
        );
    }
}
