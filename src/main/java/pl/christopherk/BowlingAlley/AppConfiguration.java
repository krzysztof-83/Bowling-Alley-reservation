package pl.christopherk.BowlingAlley;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pl.christopherk.BowlingAlley.common.AuditorProvider;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorProvider();
    }
}
