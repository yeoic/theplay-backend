package com.theplay.business.services.project.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectRepository {

    Project save(Project project);

    Optional<Project> findById(long id);

    Page<Project> findAll(ProjectSearchCondition condition, Pageable pageable);

    void delete(Project project);
}
