package jihunCompany.ai_recommendation_sns.service;

import jihunCompany.ai_recommendation_sns.domain.Post;
import jihunCompany.ai_recommendation_sns.domain.User;
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
public class PostService {

    private final UserActionRepository userActionRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Long createPost(Long userId, String content) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저가 없습니다."));
        Post post = new Post(user, content);
        postRepository.save(post);
        return post.getId();
    }

    public Post getPost(Long postid) {
        return postRepository.findById(postid)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
    }
}
