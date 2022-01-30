package com.n11.graduationproject.mapper;

import com.n11.graduationproject.dto.request.CreateCustomerDto;
import com.n11.graduationproject.dto.response.CustomerDto;
import com.n11.graduationproject.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer mapFromCreateCustomerDtoToCustomer(CreateCustomerDto dto);

    CustomerDto mapFromCustomerToCustomerDto(Customer customer);

    List<CustomerDto> mapFromCustomerListToCustomerDto(List<Customer> customer);

    CreateCustomerDto mapFromCustomerDtoToCreateCustomerDto(CustomerDto customerDto);

    CustomerDto mapFromCreateCustomerDtoToCustomerDto(CreateCustomerDto createCustomerDto);

}
