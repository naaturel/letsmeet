package be.naaturel.letsmeet.models;

import java.util.Objects;

public class EventDate {

    private long timeStamp;

    public EventDate(long timeStamp){
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

}
