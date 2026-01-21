package jihunCompany.ai_recommendation_sns.repository;

import jihunCompany.ai_recommendation_sns.domain.UserAction;
import jihunCompany.ai_recommendation_sns.domain.action.ActionType;
import jihunCompany.ai_recommendation_sns.dto.ActionExportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserActionRepository extends JpaRepository<UserAction, Long> {

    List<UserAction> findAllByUser_Id(Long userId);

    List<UserAction> findAllByPost_Id(Long postId);

    boolean existsByUserIdAndPostIdAndActionType(
            Long userId, Long postId, ActionType actionType
    );

    @Query("""
            select new jihunCompany.ai_recommendation_sns.dto.ActionExportDto(
                ua.user.id,
                ua.post.id,
                ua.actionType,
                ua.createdAt
            )
            from UserAction ua
            """)
    List<ActionExportDto> exportAll();

}
