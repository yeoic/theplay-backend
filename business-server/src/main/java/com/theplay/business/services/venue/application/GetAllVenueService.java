package com.theplay.business.services.venue.application;

import com.theplay.business.services.venue.application.dto.GetAllVenueDto;
import com.theplay.business.services.venue.application.resource.GetVenueResource;
import com.theplay.business.services.venue.domain.VenueRepository;
import com.theplay.core.presentation.response.PageResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAllVenueService {

    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;

    @Transactional(readOnly = true)
    public PageResource<GetVenueResource> getAll(GetAllVenueDto dto) {
        return PageResource.of(
                venueRepository.findAll(venueMapper.mapFrom(dto), dto.pageable()),
                GetVenueResource::from);
    }
}
