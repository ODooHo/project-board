package com.board.projectboard.repository.querydsl;

import com.board.projectboard.domain.Article;
import com.board.projectboard.domain.QArticle;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ArticleCustomRepositoryImpl extends QuerydslRepositorySupport implements ArticleCustomRepository {

    public ArticleCustomRepositoryImpl() {
        super(Article.class);
    }

    @Override
    public List<String> findAllDistinctHashtags(){
        QArticle article = QArticle.article;

        return from(article)
                .distinct()
                .select(article.hashtag)
                .where(article.hashtag.isNotNull())
                .fetch();
    }

}
