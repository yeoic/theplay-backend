package com.theplay.business.services.customer.application;

import com.theplay.business.services.customer.application.dto.GetAllCustomerDto;
import com.theplay.business.services.customer.application.resource.GetCustomerResource;
import com.theplay.business.services.customer.domain.CustomerRepository;
import com.theplay.core.presentation.response.PageResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAllCustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional(readOnly = true)
    public PageResource<GetCustomerResource> getAll(GetAllCustomerDto dto) {
        return PageResource.of(
                customerRepository.findAll(customerMapper.mapFrom(dto), dto.pageable()),
                GetCustomerResource::from);
    }
}
