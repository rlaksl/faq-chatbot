package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class BackApplicationTests {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  @DisplayName("테스트 DB(PGroonga 이미지)에서 pgroonga 확장을 설치할 수 있다")
  void t0() {
    Integer count = jdbcTemplate.queryForObject(
        "SELECT COUNT(*) FROM pg_available_extensions WHERE name = 'pgroonga'", Integer.class);
    assertEquals(1, count);
  }
}
