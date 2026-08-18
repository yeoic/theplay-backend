package com.theplay.business.services.project.domain;

import java.time.LocalDate;

public record ProjectSearchCondition(String name, Long customerId, ProjectStatus status, LocalDate performanceDateFrom, LocalDate performanceDateTo) {
}
