package be.naaturel.letsmeet.dto.httpRequest;

import java.util.Objects;

public class EventDateDTO {

    public long timestamp;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EventDateDTO date = (EventDateDTO) obj;
        return Objects.equals(timestamp, date.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp);
    }

}
