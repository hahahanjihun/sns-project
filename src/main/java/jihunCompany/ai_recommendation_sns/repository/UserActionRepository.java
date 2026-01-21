package jihunCompany.ai_recommendation_sns.repository;

import jihunCompany.ai_recommendation_sns.domain.UserAction;
import jihunCompany.ai_recommendation_sns.domain.action.ActionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserActionRepository extends JpaRepository<UserAction, Long> {

    List<UserAction> findAllByUserId(Long userId);

    List<UserAction> findAllByPostId(Long postId);

    boolean existsByUserIdAndPostIdAndActionType(
            Long userId, Long postId, ActionType actionType
    );
}
