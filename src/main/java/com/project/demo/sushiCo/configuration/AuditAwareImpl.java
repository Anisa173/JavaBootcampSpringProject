package com.project.demo.sushiCo.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditAwareImpl implements AuditorAware<Integer>{

	@Override
	public Optional<Integer> getCurrentAuditor() {
		if (SecurityUtils.getLoggedUserId() != null)
			return (Optional<Integer>) Optional.of(SecurityUtils.getLoggedUserId());
		else
		return Optional.empty();
	}

}
