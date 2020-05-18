package pl.christopherk.BowlingAlley.persistance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.christopherk.BowlingAlley.persistance.domain.TrackEntity;

import java.util.Optional;

@Repository
public interface TrackRepository extends CrudRepository<TrackEntity, Long> {

    Optional<TrackEntity> findTrackByName(String name);
    Optional<TrackEntity> findTrackByNumber(int number);
}
