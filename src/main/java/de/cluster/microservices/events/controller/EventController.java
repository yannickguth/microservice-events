package de.cluster.microservices.events.controller;

import de.cluster.microservices.events.model.Event;
import de.cluster.microservices.events.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RestController
public class EventController {

    private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    /**
     * all events
     *
     * @return
     */
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getAllEvents() {
        LOG.info("Fetching all events");
        return new ResponseEntity<>(eventService.getEvents(), HttpStatus.OK);
    }

    /**
     * create event
     *
     * @return
     */
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        LOG.info("Creating event[" + event + "]");
        String id = eventService.createEvent(event);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    /**
     * update event
     *
     * @return
     */
    @RequestMapping(value = "/events", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEvent(@RequestBody Event event) {
        LOG.info("Updating event[" + event + "]");
        eventService.updateEvent(event);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    /**
     * delete event
     *
     * @return
     */
    @RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEvent(@PathVariable String id) {
        LOG.info("Delete event[id=" + id + "]");
        eventService.deleteEvent(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    /**
     * event by id
     */
    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public ResponseEntity<Event> getEventById(
            @PathVariable String id) {
        LOG.info("Fetching event[" + id + "]");
        Event e = eventService.getEvent(id);
        if (e == null) {
            LOG.warn("Event not found[" + id + "]");
            return new ResponseEntity<>((Event) null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @RequestMapping(value = "/events/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> searchForEvents(
            @PathVariable String name) {
        LOG.info("Search for events by name");
        List<Event> events = eventService.getEventyByNameLike(name);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
