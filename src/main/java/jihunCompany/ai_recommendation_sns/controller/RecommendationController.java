package jihunCompany.ai_recommendation_sns.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommend")
public class RecommendationController {

    /**
     * 🔥 이 API는 나중에 AI 서버 결과를 그대로 반환
     */
    @GetMapping
    public List<Long> recommend(@RequestParam Long userId) {
        return List.of(); // AI 서버 연동 자리
    }
}
