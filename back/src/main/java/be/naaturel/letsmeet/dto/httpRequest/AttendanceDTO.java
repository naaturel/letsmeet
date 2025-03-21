package be.naaturel.letsmeet.dto.httpRequest;

import java.util.Objects;

public class AttendanceDTO {
    public EventDateDTO date;
    public AttendeeDTO attendee;

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AttendanceDTO a = (AttendanceDTO) obj;
        return a.date.timestamp == ((AttendanceDTO) obj).date.timestamp &&
                a.attendee.name == ((AttendanceDTO) obj).attendee.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, attendee);
    }
}
