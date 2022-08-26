package com.bvc.digitalevents.persistence;

import com.bvc.digitalevents.domain.RegistryEvent;
import com.bvc.digitalevents.domain.repository.EventDomainRepository;
import com.bvc.digitalevents.persistence.entity.Event;
import com.bvc.digitalevents.persistence.entity.EventPerPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EventDomainRepositoryImp implements EventDomainRepository {


    @Autowired
    private EventPlatformRepository eventPlatformRepository;

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public boolean hasPlatformAndEvent(String idPlatform, String idEvent) {

        return eventRepository.existsById(idEvent) && platformRepository.existsById(idPlatform);
    }

    @Override
    public RegistryEvent getEventPlatform(String idPlatform, String idEvent, LocalDate initDate) {
        RegistryEvent registryEvent = null;
        Optional<EventPerPlatform> eventPerPlatform = eventPlatformRepository.findByInitDateAndPlatformIdAndEventId(initDate, idPlatform, idEvent);
        if (eventPerPlatform.isPresent()) {
            registryEvent = eventPerPlatform.map(event ->
                    new RegistryEvent(event.getEventId(),
                            event.getPlatformId(),
                            event.getInitDate(),
                            event.getQuantity(),
                            event.getPrice())).get();
        }
        return registryEvent;
    }

    @Transactional
    @Override
    public RegistryEvent saveEventPlatform(RegistryEvent registryEvent) {
        EventPerPlatform perPlatform = new EventPerPlatform(
                registryEvent.getInitDate(),
                registryEvent.getIdPlatform(),
                registryEvent.getIdEvent(),
                registryEvent.getQuantity(),
                registryEvent.getPrice());
        EventPerPlatform event = eventPlatformRepository.save(perPlatform);

        return new RegistryEvent(
                event.getEventId(),
                event.getPlatformId(),
                event.getInitDate(),
                event.getQuantity(),
                event.getPrice());
    }

    @Override
    public Float getPricePerEvent(String idEvent) {
        return eventRepository.findById(idEvent).map(Event::getUnitValue).orElse(0.0F);
    }

    @Override
    public List<RegistryEvent> getEventsByMonthPerPlatform(String idPlatform, LocalDate date) {
        List<EventPerPlatform> event = eventPlatformRepository.getEventPlatformByMonth(idPlatform, date.getMonthValue());
        return event.stream()
                .map(eventPerPlatform ->
                        new RegistryEvent(
                                eventPerPlatform.getEventId().trim(),
                                eventPerPlatform.getPlatformId().trim(),
                                eventPerPlatform.getInitDate(),
                                eventPerPlatform.getQuantity(),
                                eventPerPlatform.getPrice()
                        )
                ).collect(Collectors.toList());
    }


}
