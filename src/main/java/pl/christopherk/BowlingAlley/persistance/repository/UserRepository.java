package pl.christopherk.BowlingAlley.persistance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.christopherk.BowlingAlley.persistance.domain.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByName(String username);
    Optional<UserEntity> findUserByEmail(String emial);
}
