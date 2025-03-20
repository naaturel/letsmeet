package be.naaturel.letsmeet.mock.models;

import be.naaturel.letsmeet.core.models.Attendee;
import be.naaturel.letsmeet.core.models.Event;

import java.util.HashSet;
import java.util.Set;

public class MockEventModel extends Event {
    public MockEventModel() {
        super("Mock event model", new HashSet<>());
    }
}
