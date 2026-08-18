package com.theplay.business.services.provider.domain;

import com.theplay.core.domain.AggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "provider")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Provider extends AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 20)
    private ProviderCategory category;

    @Column(name = "manager_name", nullable = true, length = 30)
    private String managerName;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    public Provider(String name, ProviderCategory category, String managerName, String phoneNumber) {
        this.name = name;
        this.category = category;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
    }

    @Builder
    private Provider(Long id, String name, ProviderCategory category, String managerName, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
    }
}
