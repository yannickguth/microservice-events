package de.cluster.microservices.events.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
public class Event implements Serializable {

    private static final long serialVersionUID = 1773603563972204265L;

    @Id
    private String id;

    private String eventName;

    private String locationId;

    private String ticketId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    public Event() {

    }

    public Event(String id, String eventName, String locationId, Date date, String ticketId) {
        this.setId(id);
        this.setEventName(eventName);
        this.setLocationId(locationId);
        this.setDate(date);
        this.setTicketId(ticketId);
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Event[id=" + id + ", name=" + eventName + ", date=" + date + ", locationId=" + locationId + ", ticketId=+" + ticketId + "]";
    }
}
