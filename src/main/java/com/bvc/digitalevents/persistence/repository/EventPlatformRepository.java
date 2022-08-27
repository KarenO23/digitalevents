package com.bvc.digitalevents.persistence.repository;

import com.bvc.digitalevents.persistence.entity.EventPerPlatform;
import com.bvc.digitalevents.persistence.entity.EventPerPlatformPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventPlatformRepository extends JpaRepository<EventPerPlatform, EventPerPlatformPK> {

    Optional<EventPerPlatform> findByInitDateAndPlatformIdAndEventId(LocalDate initDate, String idPlatform, String idEvent);

    @Query(
            value = "SELECT * FROM event_platform ep WHERE ep.id_platform = :id_platform AND EXTRACT(MONTH FROM ep.init_date) = :month",
            nativeQuery = true)
    List<EventPerPlatform> getEventPlatformByMonth(@Param("id_platform") String idPlatform,
                                                   @Param("month") int month);
}
