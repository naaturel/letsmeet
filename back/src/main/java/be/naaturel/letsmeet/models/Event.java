package be.naaturel.letsmeet.models;

public class Event {

    private String name;
    private long[] timestamp;

    public Event(String name, long[] timestamp){
        this.name = name;
        this.timestamp = timestamp;
    }
}
