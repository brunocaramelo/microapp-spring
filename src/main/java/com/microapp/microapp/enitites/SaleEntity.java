package com.microapp.microapp.enitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "sales")
public class SaleEntity {
        @Id
        private Integer saleId;

        @ManyToOne
        @JoinColumn(name = "listing_id")
        private ListingEntity listing;

        @ManyToOne
        @JoinColumn(name = "seller_id")
        private UserEntity seller;

        @ManyToOne
        @JoinColumn(name = "buyer_id")
        private UserEntity buyer;

        @ManyToOne
        @JoinColumn(name = "event_id")
        private EventEntity event;

        @ManyToOne
        @JoinColumn(name = "date_id")
        private DateEntity date;

        @Column(name = "quantity_sold", nullable = false)
        private Integer quantitySold;

        @Column(name = "price_paid", nullable = false)
        private BigDecimal pricePaid;

        @Column(name = "commission_amount", nullable = false)
        private BigDecimal commissionAmount;

        @Column(name = "sale_timestamp", nullable = false)
        private LocalDateTime saleTimestamp;

    }
