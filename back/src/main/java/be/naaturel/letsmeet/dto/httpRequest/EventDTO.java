package be.naaturel.letsmeet.dto.httpRequest;

import java.util.Map;
import java.util.Set;

public class EventDTO {

    public String name;
    public String token;
    public Map<String, Set<AttendeeDTO>> dates;

}
