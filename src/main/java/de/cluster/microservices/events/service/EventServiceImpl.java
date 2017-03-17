package de.cluster.microservices.events.service;

import de.cluster.microservices.events.dao.EventRepository;
import de.cluster.microservices.events.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@Service
public class EventServiceImpl implements EventService {

    private static final Logger LOG = LoggerFactory.getLogger(EventServiceImpl.class);

    @Autowired
    EventRepository eventRepo;

    @Override
    public void createData() {
        LOG.info("Creating test data: events");
        try {
            if (getEvents().size() == 0) {
                createEvent(new Event("0", "Adesso Weihnachtsfeier", "0", new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse("19.12.2017"), "0"));
                createEvent(new Event("1", "Halloween", "1", new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse("31.10.2017"), "1"));
                createEvent(new Event("2", "HS Bochum Abschlussfeier", "2", new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse("15.04.2017"), "2"));
                createEvent(new Event("3", "Silvester Party", "3", new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse("31.12.2017"), "3"));
            }
        } catch (Exception e) {
            LOG.error("Could not create Test Data");
        }
        LOG.info("Test Data created");
    }

    @Override
    public List<Event> getEventyByNameLike(String name) {
        return eventRepo.findByEventNameLikeIgnoreCase(name);
    }

    @Override
    public List<Event> getEventyByLocationIdLike(String locationId) {
        return eventRepo.findByLocationIdLike(locationId);
    }

    @Override
    public List<Event> getEventyByTicketIdLike(String ticketId) {
        return eventRepo.findByTicketIdLike(ticketId);
    }

    @Override
    public List<Event> getEvents() {
        return (List<Event>) eventRepo.findAll();
    }

    @Override
    public String createEvent(Event e) {
        return eventRepo.save(e).getId();
    }

    @Override
    public void updateEvent(Event e) {
        eventRepo.save(e);
    }

    @Override
    public Event getEvent(String id) {
        return eventRepo.findOne(id);
    }

    @Override
    public void deleteEvent(String id) {
        eventRepo.delete(id);
    }
}
