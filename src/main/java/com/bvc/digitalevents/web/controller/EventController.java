package com.bvc.digitalevents.web.controller;

import com.bvc.digitalevents.domain.RegistryEvent;
import com.bvc.digitalevents.domain.service.EventService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/registry")
    @ApiOperation("Registry the digital events.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Event or platform not found")
    })
    public ResponseEntity<ResponseDto> registryEventController(
            @ApiParam(value = "The id of the platform", required = true, example = "PACTO")
            @RequestParam String idPlatform,
            @ApiParam(value = "The id of the event", required = true, example = "F001")
            @RequestParam String idEvent,
            @ApiParam(value = "Registry the date", required = true, example = "02/08/2022")
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate initDate) throws Exception {

        try {
            eventService.registerEvent(idPlatform, idEvent, initDate);
            return ResponseEntity.ok(new ResponseDto("OK"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto(e.getMessage()));
        }
    }

    @GetMapping("/platform")
    @ApiOperation("Get events per platform by month.")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<RegistryEvent>> getDigitalEventPerPlatform(
            @ApiParam(value = "The id of the platform", required = true, example = "PACTO")
            @RequestParam String idPlatform,
            @ApiParam(value = "Date of consult the platform", required = true, example = "02/08/2022")
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {

        List<RegistryEvent> eventList = eventService.getEventsByMonthPerPlatform(idPlatform, date);

        return ResponseEntity.ok(eventList);
    }
}
