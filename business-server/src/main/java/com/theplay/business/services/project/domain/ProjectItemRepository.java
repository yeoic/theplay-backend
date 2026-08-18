package com.theplay.business.services.project.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectItemRepository {

    ProjectItem save(ProjectItem projectItem);

    Optional<ProjectItem> findById(long id);

    Page<ProjectItem> findAll(ProjectItemSearchCondition condition, Pageable pageable);

    void delete(ProjectItem projectItem);
}
