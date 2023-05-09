package com.sahu.um.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.sahu.um.audit.AuditAwareImp;

@Configurable
@EnableJpaAuditing
public class AppConfig {

	@Bean
	public AuditorAware<Long> auditorAware(){
		return new AuditAwareImp();
	}
}
