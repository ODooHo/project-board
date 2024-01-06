package com.board.projectboard.repository;

import com.board.projectboard.config.JpaConfig;
import com.board.projectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleCommentRepository articleCommentRepository;



    @DisplayName("select test")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        //given

        //when
        List<Article> articles = articleRepository.findAll();
        //then
        assertThat(articles)
                .isNotNull()
                .hasSize(123);
    }

    @DisplayName("insert test")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){
        //given
        long previousCount = articleRepository.count();
        //when
        Article savedArticle = articleRepository.save(Article.of("new title","new content","#hashtag"));
        //then
        long nowCount = articleRepository.count();
        assertThat(nowCount).isEqualTo(previousCount + 1);

    }

    @DisplayName("update test")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#Springboot";
        article.setHashtag(updatedHashtag);
        //when
        Article savedArticle = articleRepository.saveAndFlush(article);
        //then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag",updatedHashtag);

    }

    @DisplayName("delete test")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousCount = articleRepository.count();
        long previousCommentCount = articleCommentRepository.count();

        int deletedCommentSize = article.getArticleComments().size();
        //when
        articleRepository.delete(article);
        //then
        assertThat(articleRepository.count()).isEqualTo(previousCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousCommentCount - deletedCommentSize);

    }


}