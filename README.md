## 숫자 게임 구현

### 기능 요구 사항 정리

- 역할 분리하기
    - [O] Ball에서 Position, Number 상태 값
        - [O] 유효성 검증
          - [O] 1 ~ 9 범위
    - [O] Ball과 Ball 비교
        - [O] (1, 1) -> (1, 1) => Strike
        - [O] (1, 1) -> (1, 3) => Nothing
    - [O] Balls에서 Ball 목록
        - [O] (1, 1), (2, 2), (3, 3) - (2, 1) => Ball
        - [O] (1, 1), (2, 2), (3, 3) - (1, 1), (2, 6), (3, 9)
    - [O] Result에서 Balls 와 Balls를 비교한 상태 값
        - [O] 결과 값을 전달받아 Counting => 1 Strike, 1 Ball