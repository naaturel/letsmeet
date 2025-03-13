package be.naaturel.letsmeet.controllers;

import be.naaturel.letsmeet.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    public EventController(){
    }

    @PostMapping({"/create", "/create/"})
    public ResponseEntity<?> submit(@RequestBody Event e){

        return ResponseEntity.ok().build();
    }

    @GetMapping({"/join", "/join/"})
    public ResponseEntity<?> leaderboard(){
        return ResponseEntity.ok().build();
    }

}