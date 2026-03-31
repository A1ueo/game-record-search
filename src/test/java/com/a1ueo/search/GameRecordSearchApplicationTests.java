package com.a1ueo.search;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "riot.api-key=test-key",
    "spring.autoconfigure.exclude=org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration"
})
class GameRecordSearchApplicationTests {

  @Test
  void contextLoads() {
  }

}
