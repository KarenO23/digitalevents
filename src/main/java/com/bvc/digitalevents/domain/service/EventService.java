package com.bvc.digitalevents.domain.service;

import com.bvc.digitalevents.domain.RegistryEvent;
import com.bvc.digitalevents.domain.repository.EventDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    private static final String ERROR_MESSAGE = "El evento o plataforma no se encuentra registrado";

    @Autowired
    private EventDomainRepository eventDomainRepository;

    public void registerEvent(String idPlatform, String idEvent, LocalDate initDate) throws Exception {
        if (eventDomainRepository.hasPlatformAndEvent(idPlatform, idEvent)) {
            RegistryEvent registryEvent = eventDomainRepository.getEventPlatform(idPlatform, idEvent, initDate);
            Float price = eventDomainRepository.getPricePerEvent(idEvent);
            if (registryEvent == null) {
                eventDomainRepository.saveEventPlatform(
                        new RegistryEvent(
                                idEvent,
                                idPlatform,
                                initDate,
                                1,
                                price
                        )
                );
            } else {
                int quantity = registryEvent.getQuantity() + 1;
                eventDomainRepository.saveEventPlatform(
                        new RegistryEvent(registryEvent.getIdEvent(),
                                registryEvent.getIdPlatform(),
                                registryEvent.getInitDate(),
                                quantity,
                                price * quantity));
            }
        } else {
            throw new Exception(ERROR_MESSAGE);
        }
    }

    public List<RegistryEvent> getEventsByMonthPerPlatform(String idPlatform, LocalDate date) {
        return eventDomainRepository.getEventsByMonthPerPlatform(idPlatform, date);
    }
}
