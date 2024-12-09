package com.microapp.microapp.enitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "listings")
public class ListingEntity {
    @Id
    private Integer listingId;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserEntity seller;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "date_id")
    private DateEntity date;

    private Integer numberOfTickets;

    private BigDecimal pricePerTicket;

    private BigDecimal totalPrice;

    private LocalDateTime listingTimestamp;

}
