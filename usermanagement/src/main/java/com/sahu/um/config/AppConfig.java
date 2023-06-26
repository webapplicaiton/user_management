package com.sahu.um.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sahu.um.audit.AuditAwareImp;

@Configuration
@EnableJpaAuditing
public class AppConfig {

	@Bean
	public AuditorAware<Long> auditorAware(){
		return new AuditAwareImp();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
