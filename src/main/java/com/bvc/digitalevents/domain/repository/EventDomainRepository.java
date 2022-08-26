package com.bvc.digitalevents.domain.repository;

import com.bvc.digitalevents.domain.RegistryEvent;

import java.time.LocalDate;
import java.util.List;

public interface EventDomainRepository {

    boolean hasPlatformAndEvent(String platform, String event);

    RegistryEvent getEventPlatform(String idPlatform, String idEvent, LocalDate initDate);

    RegistryEvent saveEventPlatform (RegistryEvent registryEvent);

    Float getPricePerEvent (String idEvent);

    List<RegistryEvent> getEventsByMonthPerPlatform(String idPlatform, LocalDate date);




}
