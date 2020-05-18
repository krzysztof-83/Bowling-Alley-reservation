package pl.christopherk.BowlingAlley.common;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.christopherk.BowlingAlley.security.CustomUserDetails;

import java.util.Optional;

public class AuditorProvider implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        CustomUserDetails principal = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(principal.getUsername());
    }
}
