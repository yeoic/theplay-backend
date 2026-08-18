package com.theplay.business.services.project.domain;


public record ProjectItemSearchCondition(Long projectId, Long providerJobId, ProjectItemStatus status) {
}
