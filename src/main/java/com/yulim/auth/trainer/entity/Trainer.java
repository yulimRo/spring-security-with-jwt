package com.yulim.auth.trainer.entity;

import com.yulim.auth.common.entity.BaseEntity;
import com.yulim.auth.common.type.EmpStatus;
import com.yulim.auth.common.type.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@DynamicUpdate
@DynamicInsert
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
