package jihunCompany.ai_recommendation_sns.dto;

import jihunCompany.ai_recommendation_sns.domain.action.ActionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ActionExportDto {
    private Long userId;
    private Long postId;
    private String action;
    private LocalDateTime timestamp;

    // 생성자에서 ActionType을 받아 String으로 변환합니다.
    public ActionExportDto(Long userId, Long postId, ActionType actionType, LocalDateTime timestamp) {
        this.userId = userId;
        this.postId = postId;
        this.action = (actionType != null) ? actionType.name() : null;
        this.timestamp = timestamp;
    }
}
