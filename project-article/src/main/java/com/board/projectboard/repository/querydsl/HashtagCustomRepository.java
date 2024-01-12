package com.board.projectboard.repository.querydsl;

import java.util.List;

public interface HashtagCustomRepository {
    List<String> findAllHashtagNames();
}
