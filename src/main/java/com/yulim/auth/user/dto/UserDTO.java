package com.yulim.auth.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;
    private String userId;
    private String password;
    private String userName;
    private String createDate;
    private String creatorId;
    private String updateDate;
    private String updateId;
}
