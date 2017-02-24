package de.cluster.microservices.events.dao;

import de.cluster.microservices.events.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
    List<Event> findByLocationIdLike(String locationId);

    List<Event> findByArtistIdLike(String artistId);

    List<Event> findByTicketIdLike(String ticketId);

    List<Event> findByEventNameLikeIgnoreCase(String eventName);

    List<Event> findByDateBetween(Date start, Date end);

}
