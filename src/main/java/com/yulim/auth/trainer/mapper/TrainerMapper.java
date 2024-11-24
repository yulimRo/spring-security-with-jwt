package com.yulim.auth.trainer.mapper;

import com.yulim.auth.trainer.entity.Trainer;
import com.yulim.auth.trainer.entity.TrainerDTO;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class TrainerMapper {

    public Trainer toEntity(TrainerDTO trainerDTO) {
        return Trainer.builder()
                .id(trainerDTO.getId())
                .no(trainerDTO.getNo())
                .name(trainerDTO.getName())
                .tel(trainerDTO.getTel())
                .birth(trainerDTO.getBirth())
                .addr1(trainerDTO.getAddr1())
                .addr2(trainerDTO.getAddr2())
                .gender(trainerDTO.getGender())
                .empStatus(trainerDTO.getEmpStatus())
                .etc(trainerDTO.getEtc())
                .build();
    }

    public TrainerDTO toDTO(Trainer trainerEntity) {
        return TrainerDTO.builder()
                .id(trainerEntity.getId())
                .no(trainerEntity.getNo())
                .name(trainerEntity.getName())
                .tel(trainerEntity.getTel())
                .birth(trainerEntity.getBirth())
                .addr1(trainerEntity.getAddr1())
                .addr2(trainerEntity.getAddr2())
                .gender(trainerEntity.getGender())
                .empStatus(trainerEntity.getEmpStatus())
                .etc(trainerEntity.getEtc())
                .createDate(trainerEntity.getCreateDate() != null ? trainerEntity.getCreateDate().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) : null)
                .creatorId(trainerEntity.getCreatorId())
                .updateDate(trainerEntity.getUpdateDate() != null ? trainerEntity.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) : null)
                .updateId(trainerEntity.getUpdaterId())
                .build();
    }

    public void updateTrainer(Trainer existingTrainer, TrainerDTO updateTrainerDTO){
        existingTrainer.setName(updateTrainerDTO.getName());
        existingTrainer.setAddr1(updateTrainerDTO.getAddr1());
        existingTrainer.setAddr2(updateTrainerDTO.getAddr2());
        existingTrainer.setGender(updateTrainerDTO.getGender());
        existingTrainer.setEmpStatus(updateTrainerDTO.getEmpStatus());
        existingTrainer.setTel(updateTrainerDTO.getTel());
        existingTrainer.setBirth(updateTrainerDTO.getBirth());
        existingTrainer.setEtc(updateTrainerDTO.getEtc());
    }

}
