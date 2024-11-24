package com.yulim.auth.trainer.repository.querydsl;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yulim.auth.trainer.entity.QTrainer;
import com.yulim.auth.trainer.entity.Trainer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class TrainerQueryDslRepositoryImpl implements TrainerQueryDslRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public String getLastTrainerNo() {
        QTrainer qTrainer = QTrainer.trainer;
        return queryFactory.select(qTrainer.no)
                .from(qTrainer)
                .orderBy(qTrainer.no.desc())
                .fetchFirst();
    }
}
