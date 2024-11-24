package com.yulim.auth;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class TestRuner {

    @Test
    void test() {
        String no = "000002";

        Integer newTrainerNum =  Integer.parseInt(no) + 1;
        StringUtils.leftPad(String.valueOf(newTrainerNum),4,"0");

        System.out.println(StringUtils.leftPad(String.valueOf(newTrainerNum),4,"0"));

    }
}
