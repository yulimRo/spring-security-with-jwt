package com.yulim.auth.trainer.service;

import com.yulim.auth.trainer.entity.TrainerDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TrainerService {

    public TrainerDTO createTrainer(TrainerDTO trainerDTO);
    public TrainerDTO updateTrainer(TrainerDTO trainerDTO, Long id);
    public TrainerDTO getTrainer(Long id);
    public Page<TrainerDTO> getTrainerList();
    public void deleteTrainer(Long id);
    public void deleteTrainerList(List<Long> ids);
}
