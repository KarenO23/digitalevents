package com.bvc.digitalevents.persistence;

import com.bvc.digitalevents.persistence.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, String> {

    Optional<Event> findById(String id);

}
