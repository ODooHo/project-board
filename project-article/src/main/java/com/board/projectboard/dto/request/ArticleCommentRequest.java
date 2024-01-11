package com.board.projectboard.dto.request;


import com.board.projectboard.dto.ArticleCommentDto;
import com.board.projectboard.dto.UserAccountDto;

/**
 * DTO for {@link com.board.projectboard.domain.ArticleComment}
 */
public record ArticleCommentRequest(Long articleId, String content){
    public static ArticleCommentRequest of(Long articleId, String content){
        return new ArticleCommentRequest(articleId,content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto){
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }
}