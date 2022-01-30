package com.n11.graduationproject.service.impl;

import com.n11.graduationproject.dto.response.CustomerDto;
import com.n11.graduationproject.mapper.CustomerMapper;
import com.n11.graduationproject.model.Customer;
import com.n11.graduationproject.repository.ICustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class CustomerServiceImplTest {

    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    CustomerMapper customerMapper;

    @Mock
    ICustomerRepository customerRepository;



    @Test
    void findAll() {

        List<Customer> expected = new Vector<>();
        when(customerRepository.findAll()).thenReturn(expected);
        List<CustomerDto>  newExpected = customerMapper.mapFromCustomerListToCustomerDto(expected);
        List<CustomerDto> actual = customerService.findAll();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(newExpected.size(), actual.size()),
                () -> assertEquals(newExpected, actual)
        );
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


}