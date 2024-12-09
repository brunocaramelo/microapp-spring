package com.microapp.microapp.enitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dates")
public class DateEntity {

    @Id
    private Integer id;

    @Column(name = "calendar_date", nullable = false)
    private LocalDate calendarDate;

    @Column(name = "day", nullable = false)
    private Integer day;

    @Column(name = "week", nullable = false)
    private Integer week;

    @Column(name = "month", nullable = false)
    private Integer month;

    @Column(name = "quarter", nullable = false)
    private Integer quarter;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "holiday_flag", nullable = false)
    Boolean holidayFlag;

}
