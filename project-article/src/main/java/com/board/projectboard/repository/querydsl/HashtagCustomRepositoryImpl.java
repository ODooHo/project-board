package com.board.projectboard.repository.querydsl;

import com.board.projectboard.domain.Hashtag;
import com.board.projectboard.domain.QHashtag;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class HashtagCustomRepositoryImpl extends QuerydslRepositorySupport implements HashtagCustomRepository{
    public HashtagCustomRepositoryImpl() {
        super(Hashtag.class);
    }

    @Override
    public List<String> findAllHashtagNames() {
        QHashtag hashtag = QHashtag.hashtag;

        return from(hashtag)
                .select(hashtag.hashtagName)
                .fetch();
    }
}
