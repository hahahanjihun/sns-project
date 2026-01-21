[프로젝트 상태 요약]

- Spring Boot + JPA SNS 백엔드
- Entity: User, Post, UserAction(VIEW, LIKE)
- API
    - POST /actions/view
    - POST /actions/like
    - GET /actions/export (AI 학습용)
- UserAction export DTO:
  userId, postId, action(String), timestamp

- Python 추천 시스템
    - 위치: ai-recommendation-sns/ai_model
    - venv 사용
    - 라이브러리: pandas, numpy, scikit-learn, requests
    - Spring export API 호출해서 DataFrame 생성까지 완료

- 다음 목표:
  VIEW/LIKE 가중치 → 추천 점수 계산
