package main.com.mappers;

import main.com.models.Event;

import java.util.List;

/**
 * Created by Alex on 13.12.2015.
 */
public interface EventMapper {
    public List<Event> getEventsByCallId(int id);

    public void insertEvent(Event event);
}
