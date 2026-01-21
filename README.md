# fortest

## RedisIntegrationTest 실행 오류 정리

### 문제 증상
`RedisIntegrationTest` 실행 시 아래와 같은 컴파일 오류가 발생했습니다.

```
import com.backend.backend.domain.mapping.entity.Action;
                                                ^
  symbol:   class Action
  location: package com.backend.backend.domain.mapping.entity
```

### 원인
- 여러 도메인 엔티티 클래스가 파일 경로와 다른 패키지로 선언되어 있었습니다.
  - 예: `Action`은 `backend/src/main/java/com/backend/backend/domain/mapping/entity/Action.java` 경로에 있지만,
    패키지가 `com.backend.backend.entity`로 선언됨.
- 이로 인해 Mapper 인터페이스 및 MyBatis XML이 기대하는 패키지와 실제 패키지가 불일치하여
  테스트 컴파일 시 `Action`을 찾지 못했습니다.
- MyBatis XML의 `namespace`, `resultMap type`, `parameterType` 또한
  현재 코드 구조와 맞지 않는 패키지를 참조하고 있었습니다.

### 해결
- 도메인 엔티티의 패키지 선언을 파일 경로와 동일하게 정리했습니다.
- 모든 MyBatis XML의 `namespace`, `resultMap type`, `parameterType`을
  실제 패키지(`com.backend.backend.domain.*`) 기준으로 정정했습니다.

### 수정 사항 요약
1. 엔티티 패키지 정리
   - `Action`, `Gesture` → `com.backend.backend.domain.mapping.entity`
   - `Presentation`, `PresentationAudio`, `PresentationScript`, `Feedback`
     → `com.backend.backend.domain.presentation.entity`
2. MyBatis XML 정리
   - 각 Mapper XML의 `namespace`를 실제 Mapper 인터페이스 패키지로 정정.
   - `resultMap type`, `parameterType`, `association javaType`을 실제 엔티티 패키지로 정정.

이제 `RedisIntegrationTest`를 실행해 Redis에 데이터가 정상적으로 저장/조회되는지 확인할 수 있습니다.
