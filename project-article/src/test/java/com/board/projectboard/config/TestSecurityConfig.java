package com.board.projectboard.config;

import com.board.projectboard.domain.UserAccount;
import com.board.projectboard.repository.UserAccountRepository;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

@Import(SecurityConfig.class)
public class TestSecurityConfig {
    @MockBean
    private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void securitySetup(){
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of(
                "test",
                "pw",
                "test@email.com",
                "test",
                "test memo"
                )
        ));
    }
}
