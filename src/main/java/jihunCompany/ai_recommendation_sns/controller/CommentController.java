package jihunCompany.ai_recommendation_sns.controller;

import jihunCompany.ai_recommendation_sns.domain.Comment;
import jihunCompany.ai_recommendation_sns.dto.CommentCreateRequest;
import jihunCompany.ai_recommendation_sns.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody CommentCreateRequest req) {
        return ResponseEntity.ok(commentService.createComment(
            req.getUserId(),
            req.getPostId(),
            req.getContent()
        ));
    }
}
