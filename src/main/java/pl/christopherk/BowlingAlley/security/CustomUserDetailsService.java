package pl.christopherk.BowlingAlley.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.christopherk.BowlingAlley.common.exceptions.UserNotFoundException;
import pl.christopherk.BowlingAlley.persistance.domain.UserEntity;
import pl.christopherk.BowlingAlley.persistance.repository.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> userFoundByName = userRepository.findUserByName(userName);
        userFoundByName.orElseThrow(() -> new UserNotFoundException(userName));
        return userFoundByName.map(CustomUserDetails::new).get();
    }
}
