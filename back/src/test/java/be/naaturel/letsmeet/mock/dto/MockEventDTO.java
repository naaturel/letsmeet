package be.naaturel.letsmeet.mock.dto;

import be.naaturel.letsmeet.core.models.Attendee;
import be.naaturel.letsmeet.dto.httpRequest.AttendeeDTO;
import be.naaturel.letsmeet.dto.httpRequest.EventDTO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MockEventDTO extends EventDTO {

    public MockEventDTO() {
        this.name = "Mocked event";
        this.dates = new HashMap<>();
        populate(0, new HashSet<>());
        populate(1, new HashSet<>());
        populate(2, new HashSet<>());
    }

    private void populate(long timestamp, Set<AttendeeDTO> attendees){
        this.dates.put(String.valueOf(timestamp), attendees);
    }
}
