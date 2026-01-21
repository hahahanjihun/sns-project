package jihunCompany.ai_recommendation_sns.service;

import jihunCompany.ai_recommendation_sns.domain.Post;
import jihunCompany.ai_recommendation_sns.domain.User;
import jihunCompany.ai_recommendation_sns.domain.UserAction;
import jihunCompany.ai_recommendation_sns.domain.action.ActionType;
import jihunCompany.ai_recommendation_sns.dto.ActionExportDto;
import jihunCompany.ai_recommendation_sns.repository.PostRepository;
import jihunCompany.ai_recommendation_sns.repository.UserActionRepository;
import jihunCompany.ai_recommendation_sns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserActionService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserActionRepository userActionRepository;

    /*
    게시글 조회 로직
     */
    public void ViewPost(Long userId, Long postId) {
        //유저와 게시글 엔티티 조회
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("유저 없음"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

        userActionRepository.save(
                new UserAction(user, post, ActionType.VIEW)
        );
    }

    /*
    좋아요 로직
     */
    public void LikePost(Long userId, Long postId) {
        //유저와 게시글 엔티티 조회
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("유저 없음"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

        userActionRepository.save(
                new UserAction(user, post, ActionType.LIKE)
        );
    }

    /*
    모든 데이터 내보내기(DB에서 쿼리를 통해 바로 DTO로 변환)
     */
    public List<ActionExportDto> exportActions() {
        return userActionRepository.exportAll();
    }
}
