package com.yulim.auth.trainer.service;

import com.yulim.auth.common.Constant;
import com.yulim.auth.trainer.entity.Trainer;
import com.yulim.auth.trainer.entity.TrainerDTO;
import com.yulim.auth.trainer.mapper.TrainerMapper;
import com.yulim.auth.trainer.repository.TrainerRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    private TrainerMapper trainerMapper;

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public TrainerDTO createTrainer(TrainerDTO trainerDTO) {

        if(StringUtils.isEmpty(trainerDTO.getName())){
            throw new IllegalArgumentException("이름은 필수 입력값입니다.");
        }

        if(StringUtils.isEmpty(trainerDTO.getTel())){
            throw new IllegalArgumentException("연락처는 핈 입력값입니다.");
        }

        trainerDTO.setNo(generateTrainerNo());
        Trainer newTrainer =  trainerRepository.save(trainerMapper.toEntity(trainerDTO));
        return trainerMapper.toDTO(newTrainer);
    }

    @Override
    public TrainerDTO updateTrainer(TrainerDTO trainerDTO, Long id) {

        if(!trainerDTO.getId().equals(id)) {
            throw new IllegalArgumentException("수정 정보가 올바르지 않습니다. 확인 후 다시 시도바랍니다.");
        }

        Trainer existingTrainer = trainerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("트레이너 정보가 존재하지 않습니다."));

        trainerMapper.updateTrainer(existingTrainer, trainerDTO);

        Trainer updateTrainer = trainerRepository.save(existingTrainer);

        return trainerMapper.toDTO(updateTrainer);
    }

    @Override
    public TrainerDTO getTrainer(Long id) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("트레이너 정보가 존재하지 않습니다."));
        return trainerMapper.toDTO(trainer);
    }

    @Override
    public Page<TrainerDTO> getTrainerList() {
        //return trainerRepository.getTrainerList();
        return null;
    }

    @Override
    @Transactional(dontRollbackOn = EmptyResultDataAccessException.class)
    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }

    @Override
    public void deleteTrainerList(List<Long> ids) {
        for(Long id : ids){
            try{
                trainerRepository.deleteById(id);
            } catch (EmptyResultDataAccessException ex) {
                log.debug("EmptyResultDataAccessException - Delete Id - {}", id);
            }
        }
    }

    private String generateTrainerNo() {
        String lastTrainerNo = trainerRepository.getLastTrainerNo();
        String newTrainerNo = "";
        if(StringUtils.isEmpty(lastTrainerNo)) {
            newTrainerNo = Constant.TRAINER_NO_PREFIX + "000001";
        } else {
            newTrainerNo = Constant.TRAINER_NO_PREFIX + StringUtils.leftPad(String.valueOf(Integer.parseInt(lastTrainerNo.substring(4)) + 1),6,"0");
        }

        return newTrainerNo;
    }
}
