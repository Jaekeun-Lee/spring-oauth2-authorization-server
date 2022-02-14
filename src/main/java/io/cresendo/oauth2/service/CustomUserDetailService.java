package io.cresendo.oauth2.service;

import io.cresendo.oauth2.entity.User;
import io.cresendo.oauth2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public UserDetails loadUserByUsername(String name) {
        User user = userRepository.findByUid(name).orElseThrow(() -> new UsernameNotFoundException("user is not exists"));
        detailsChecker.check(user);
        return user;
    }
}
