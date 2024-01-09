package com.board.projectboard.service;

import com.board.projectboard.dto.ArticleDto;
import com.board.projectboard.dto.ArticleWithCommentsDto;
import com.board.projectboard.repository.ArticleRepository;
import com.board.projectboard.type.SearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;


    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticle(Long articleId) {
        return null;
    }
    public void saveArticle(ArticleDto dto) {
    }

    public void updateArticle(ArticleDto dto) {

    }

    public void deleteArticle(long ArticleId) {


    }
}
