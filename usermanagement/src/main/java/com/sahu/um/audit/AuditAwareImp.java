package com.sahu.um.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditAwareImp implements AuditorAware<Long> {

	@Override
	public Optional<Long> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.of(11L);
	}

}
