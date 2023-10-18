## 숫자 게임 구현

### 기능 요구 사항 정리

- 역할 분리하기
    - [ ] Ball에서 Position, Number 상태 값
        - [ ] 유효성 검증
        - [ ] Ball과 Ball 비교
            - (1, 1) -> (1, 1) => Strike
            - (1, 1) -> (1, 3) => Nothing
    - [ ] Balls에서 Ball 목록
        - [ ] (1, 1), (2, 2), (3, 3) - (2, 1) => Ball
    - [ ] Result에서 Balls 와 Balls를 비교한 상태 값
        - [ ] 결과 값을 전달받아 Counting => 1 Strike, 1 Ball