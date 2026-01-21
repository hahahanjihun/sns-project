package jihunCompany.ai_recommendation_sns.dto;

import lombok.Getter;

@Getter
public class PostCreateRequest {
    private Long userId;
    private String content;
}
