package com.theplay.business.services.venue.domain;

import com.theplay.core.domain.Address;
import com.theplay.core.domain.AggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venue")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Venue extends AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Embedded
    private Address address;

    @Column(name = "seat_count", nullable = false)
    private int seatCount;

    @Column(name = "outdoor", nullable = false)
    private boolean outdoor;

    public Venue(String name, Address address, int seatCount, boolean outdoor) {
        this.name = name;
        this.address = address;
        this.seatCount = seatCount;
        this.outdoor = outdoor;
    }

    @Builder
    private Venue(Long id, String name, Address address, int seatCount, boolean outdoor) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.seatCount = seatCount;
        this.outdoor = outdoor;
    }
}
