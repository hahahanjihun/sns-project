package jihunCompany.ai_recommendation_sns.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ActionExportDto {
    private Long userId;
    private Long postId;
    private String action;
    private LocalDateTime timestamp;
}
