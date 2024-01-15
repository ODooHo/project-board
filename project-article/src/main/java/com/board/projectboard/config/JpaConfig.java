package com.board.projectboard.config;

import com.board.projectboard.dto.security.BoardPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(principal -> {
                    if (principal instanceof BoardPrincipal) {
                        return ((BoardPrincipal) principal).getUsername();
                    }
                    return null;
                })
                .orElseThrow(() -> new UsernameNotFoundException(("유저를 찾을 수 없습니다"))).describeConstable();
    }


    /*
     이전 캐스팅 코드 백업
     */


//    @Bean
//    public AuditorAware<String> auditorAware() {
//        return () -> Optional.ofNullable(SecurityContextHolder.getContext()
//                ).map(SecurityContext::getAuthentication)
//                .filter(Authentication::isAuthenticated)
//                .map(BoardPrincipal.class::cast)
//                .map(BoardPrincipal::getUsername);
//    }
}
