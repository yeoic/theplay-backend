package com.theplay.business.services.customer.domain;

import com.theplay.core.domain.AggregateRoot;
import jakarta.persistence.Column;
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
@Table(name = "customer")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "manager_name", nullable = true, length = 30)
    private String managerName;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "email", nullable = true, length = 100)
    private String email;

    public Customer(String name, String managerName, String phoneNumber, String email) {
        this.name = name;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Builder
    private Customer(Long id, String name, String managerName, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
