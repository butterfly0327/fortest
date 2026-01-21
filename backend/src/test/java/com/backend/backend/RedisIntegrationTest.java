package com.backend.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test") // application-test.yml 사용하게 해줌
class RedisIntegrationTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void redis_set_get_테스트() {
        // 1) 키/값 준비 (충돌 방지 위해 UUID 사용)
        String key = "test:hello:" + UUID.randomUUID();
        String value = "world";

        // 2) Redis에 저장 (30초 TTL)
        stringRedisTemplate.opsForValue().set(key, value, Duration.ofSeconds(30));

        // 3) Redis에서 조회
        String result = stringRedisTemplate.opsForValue().get(key);

        // 4) 검증
        assertThat(result).isEqualTo(value);

        // 5) 정리(테스트 키 삭제)
        stringRedisTemplate.delete(key);
    }
}
