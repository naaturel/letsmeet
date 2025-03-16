package be.naaturel.letsmeet.controllers;

import be.naaturel.letsmeet.dto.httpRequest.EventDTO;
import be.naaturel.letsmeet.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final EventService service;

    @Autowired
    public EventController(EventService service){
        this.service = service;
    }

    @PostMapping({"/create", "/create/"})
    public ResponseEntity<?> submit(@RequestBody EventDTO dto){

        try{
            service.save(dto);
        } catch (Exception e){
            return ResponseEntity
                    .internalServerError()
                    .build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping({"/join", "/join/"})
    public ResponseEntity<?> leaderboard(){
        return ResponseEntity.ok().build();
    }

}