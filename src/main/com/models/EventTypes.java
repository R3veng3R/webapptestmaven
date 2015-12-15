package main.com.models;

/**
 * Created by Alex on 13.12.2015.
 */
public enum EventTypes {
    EVENT_CALL_END("EVENT_CALL_END"),
    EVENT_CALL_ESTABLISHED("EVENT_CALL_ESTABLISHED"),
    EVENT_DIAL("EVENT_DIAL"),
    EVENT_HANG_UP("EVENT_HANG_UP"),
    EVENT_PICK_UP("EVENT_PICK_UP");

    private String eventType;

    EventTypes(String eventType) {
        this.eventType = eventType;
    }


}
