package com.fligth.app.entities;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "flight")
@Data
public class Fligth {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
    @SequenceGenerator(name = "flight_seq", sequenceName = "flight_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "flight_number", length = 10, nullable = false, unique = true)
    private String flightNumber;

    @Column(name = "airline", length = 50, nullable = false)
    private String airline;

    @Column(name = "origin", length = 100, nullable = false)
    private String origin;

    @Column(name = "destination", length = 100, nullable = false)
    private String destination;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "aircraft_type", length = 50)
    private String aircraftType;

    @Column(name = "gate", length = 10)
    private String gate;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

}
