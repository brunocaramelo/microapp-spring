package com.microapp.microapp.enitites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "venues")
public class VenueEntity {

    @Id
    private int venueId;

    @Column(name = "venue_name", nullable = false)
    private String venueName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "seating_capacity", nullable = false)
    private int seatingCapacity;

}
