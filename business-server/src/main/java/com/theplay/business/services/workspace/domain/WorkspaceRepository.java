package com.theplay.business.services.workspace.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorkspaceRepository {

    Workspace save(Workspace workspace);

    Optional<Workspace> findById(long id);

    Page<Workspace> findAll(WorkspaceSearchCondition condition, Pageable pageable);

    void delete(Workspace workspace);
}
