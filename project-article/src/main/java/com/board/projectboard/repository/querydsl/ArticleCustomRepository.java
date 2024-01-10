package com.board.projectboard.repository.querydsl;

import java.util.List;

public interface ArticleCustomRepository {
    List<String> findAllDistinctHashtags();

}
