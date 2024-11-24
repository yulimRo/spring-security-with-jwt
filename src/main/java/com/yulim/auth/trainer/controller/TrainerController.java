package com.yulim.auth.trainer.controller;

import com.yulim.auth.trainer.entity.TrainerDTO;
import com.yulim.auth.trainer.service.TrainerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping("/api/trainer")
    public TrainerDTO saveTrainer(@RequestBody TrainerDTO trainerDTO) {
        return trainerService.createTrainer(trainerDTO);
    }

    @GetMapping("/api/trainer/{id}")
    public TrainerDTO getTrainer(@PathVariable Long id) {
        log.debug("트레이너 조회");
        return trainerService.getTrainer(id);
    }

    @PutMapping("/api/trainer/{id}")
    public TrainerDTO updateTrainer(@PathVariable Long id, @RequestBody TrainerDTO trainerDTO){
        return trainerService.updateTrainer(trainerDTO, id);
    }

    @DeleteMapping("/api/trainer/{id}")
    public void deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
    }

    @DeleteMapping("/api/trainer")
    public void deleteTrainer(@RequestBody List<Long> ids) {
        trainerService.deleteTrainerList(ids);
    }

}
