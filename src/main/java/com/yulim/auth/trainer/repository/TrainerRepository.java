package com.yulim.auth.trainer.repository;

import com.yulim.auth.trainer.entity.Trainer;
import com.yulim.auth.trainer.repository.querydsl.TrainerQueryDslRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer,Long>, TrainerQueryDslRepository {

}
