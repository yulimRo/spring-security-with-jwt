package com.yulim.auth.trainer.entity;

import com.yulim.auth.common.type.EmpStatus;
import com.yulim.auth.common.type.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDTO {

    private Long id;
    private String no;
    private String name;
    private String birth;
    private GenderType gender;
    private String tel;
    private String addr1;
    private String addr2;
    private EmpStatus empStatus;
    private String etc;
    private String createDate;
    private String creatorId;
    private String updateDate;
    private String updateId;
}
