package be.naaturel.letsmeet.controllers;

import be.naaturel.letsmeet.dto.httpRequest.EventDTO;
import be.naaturel.letsmeet.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {

    private final EventService service;

    @Autowired
    public EventController(EventService service){
        this.service = service;
    }


    @GetMapping({"/event", "/event/{token}"})
    public ResponseEntity<?> get(@PathVariable String token){

        try{
            EventDTO dto = service.getEvent(token);
            return ResponseEntity.ok(dto);
        } catch (Exception e){
            return ResponseEntity
                    .internalServerError()
                    .build();
        }
    }

    @PostMapping({"/create", "/create/"})
    public ResponseEntity<?> create(@RequestBody EventDTO dto){

        try{
            service.save(dto);
        } catch (Exception e){
            return ResponseEntity
                    .internalServerError()
                    .build();
        }

        return ResponseEntity.ok().build();
    }
}