package com.theplay.business.services.workspace.domain;

import com.theplay.core.domain.Address;
import com.theplay.core.domain.AggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name = "workspace")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Workspace extends AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 20)
    private WorkspaceType type;

    @Embedded
    private Address address;

    public Workspace(String name, WorkspaceType type, Address address) {
        this.name = name;
        this.type = type;
        this.address = address;
    }

    @Builder
    private Workspace(Long id, String name, WorkspaceType type, Address address) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
    }
}
