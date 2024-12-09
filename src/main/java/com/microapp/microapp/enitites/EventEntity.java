package com.microapp.microapp.enitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    private Integer eventId;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private VenueEntity venue;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "date_id")
    private DateEntity date;

    private String eventName;
    private LocalDateTime eventStartTime;

}
