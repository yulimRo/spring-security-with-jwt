package com.yulim.auth.config;

import com.yulim.auth.config.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(modifyOnCreate = false)
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorAware(){ //AuditorAware을 빈으로 등록
        return new AuditorAwareImpl();
    }
}
