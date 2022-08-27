package com.bvc.digitalevents.persistence.repository;

import com.bvc.digitalevents.persistence.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlatformRepository extends JpaRepository<Platform, String> {

    Optional<Platform> findById(String id);

}
