package com.yulim.auth.trainer.repository.querydsl;

import com.yulim.auth.trainer.entity.Trainer;
import org.springframework.data.domain.Page;

public interface TrainerQueryDslRepository {

    public String getLastTrainerNo();
}
