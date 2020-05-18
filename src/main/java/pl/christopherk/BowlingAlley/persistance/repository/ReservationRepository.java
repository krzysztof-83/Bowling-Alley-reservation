package pl.christopherk.BowlingAlley.persistance.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.christopherk.BowlingAlley.persistance.domain.ReservationEntity;

import java.time.LocalDateTime;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

    @Query("select a from ReservationEntity a join a.track c where c.name=:trackName")
    Iterable<ReservationEntity> findByTrackName(@Param("trackName") String trackName);

    @Query(value = "select * from reservation where reservation.created_by = ?1", nativeQuery = true)
    Iterable<ReservationEntity> findByCreatedBy(String email);

    @Query(value = "select a from ReservationEntity a where a.reservationStart>:date")
    Iterable<ReservationEntity> findByReservationStart(LocalDateTime date);

}
