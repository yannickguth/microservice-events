package de.cluster.microservices.events.service;

import de.cluster.microservices.events.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    public Event getEvent(String id);

    public List<Event> getEvents();

    public List<Event> getEventyByNameLike(String name);

    public List<Event> getEventyByLocationIdLike(String locationId);

    public List<Event> getEventyByArtistIdLike(String artistId);

    public List<Event> getEventyByTicketIdLike(String ticketId);

    public void deleteEvent(String id);

    public void createData();

    public String createEvent(Event e);

    public void updateEvent(Event e);
}
