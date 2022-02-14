package io.cresendo.oauth2.repository;

import io.cresendo.oauth2.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @Commit
    public void insertNewUser() {
        // given
        User user = User.builder()
                .uid("happydaddy@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .name("happydaddy")
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
        log.info("{}", user);

        User save = userRepository.save(user);
        log.info("{}", save);
    }
}
