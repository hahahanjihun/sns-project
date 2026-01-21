package jihunCompany.ai_recommendation_sns.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequest {
    private Long userId;
    private Long postId;
    private String content;
}
