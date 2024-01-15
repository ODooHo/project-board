package com.board.projectboard.service;


import com.board.projectboard.domain.UserAccount;
import com.board.projectboard.dto.UserAccountDto;
import com.board.projectboard.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Transactional(readOnly = true)
    public Optional<UserAccountDto> searchUser(String username) {
        return userAccountRepository.findById(username)
                .map(UserAccountDto::from);
    }

    public UserAccountDto saveUser(String username, String password, String email, String nickname, String memo) {
        UserAccountDto test = null;
        test = UserAccountDto.from(userAccountRepository.save(UserAccount.of(username, password, email, nickname, memo, username)));
        return test;
    }

}