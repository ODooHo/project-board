package com.board.projectboard.config;

import com.board.projectboard.dto.UserAccountDto;
import com.board.projectboard.repository.UserAccountRepository;
import com.board.projectboard.service.UserAccountService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {
    @MockBean
    private UserAccountRepository userAccountRepository;
    @MockBean
    private UserAccountService userAccountService;


    @BeforeTestMethod
    public void securitySetup(){
        given(userAccountService.searchUser(anyString())).willReturn(Optional.of(createUserAccountDto()));
        given(userAccountService.saveUser(anyString(),anyString(),anyString(),anyString(),anyString()))
                .willReturn(createUserAccountDto());
    }

    private UserAccountDto createUserAccountDto(){
        return UserAccountDto.of(
                "test",
                "pw",
                "test@email.com",
                "test",
                "test memo"
        );
    }
}
