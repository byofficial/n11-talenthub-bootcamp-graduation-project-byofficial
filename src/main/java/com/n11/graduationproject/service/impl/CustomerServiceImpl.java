package com.n11.graduationproject.service.impl;


import com.n11.graduationproject.dto.request.CreateCustomerDto;
import com.n11.graduationproject.dto.request.UpdateCustomerDto;
import com.n11.graduationproject.dto.response.CustomerDto;
import com.n11.graduationproject.exception.customer.CustomerAlreadyExistException;
import com.n11.graduationproject.exception.customer.CustomerNotFoundException;
import com.n11.graduationproject.mapper.CustomerMapper;
import com.n11.graduationproject.model.Customer;
import com.n11.graduationproject.repository.ICustomerRepository;
import com.n11.graduationproject.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CustomerServiceImpl implements ICustomerService {

    private final String CLASS_NAME_LOG = this.getClass().getSimpleName();

    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * @return Returns all customers
     */
    @Override
    public List<CustomerDto> findAll() {
        log.info(CLASS_NAME_LOG + " service findAll method is running.");
        List<CustomerDto> customerDtoList = CustomerMapper.INSTANCE.mapFromCustomerListToCustomerDto(customerRepository.findAll());
        return customerDtoList;
    }

    /**
     * @param nationalId is unique
     * @return Returns customer with unique NationalId value
     */
    @Override
    public CustomerDto findByNationalId(String nationalId) {
        log.info(CLASS_NAME_LOG + " service findByNationalId method is running.");

        CustomerDto customerDto = CustomerMapper.INSTANCE.mapFromCustomerToCustomerDto(findByNationalIdCustomer(nationalId));

        return customerDto;
    }

    /**
     * @param nationalId  is unique
     * @param dateOfBirth type is Date (YYYY-MM-DD)
     * @return Returns (True or False). Queries whether the birth date and national identity number given as parameters are registered in the system.
     */
    @Override
    public boolean existsByNationalIdNumberAndDateOfBirthGreaterThan(String nationalId, LocalDate dateOfBirth) {
        log.info(CLASS_NAME_LOG + " service existsByNationalIdNumberAndDateOfBirthGreaterThan method is running.");
        boolean isCustomerExist = customerRepository.existsByNationalIdNumberAndDateOfBirthGreaterThan(nationalId, dateOfBirth);

        if (!isCustomerExist) {
            log.error("Customer Not Found!: " + nationalId);
            throw new CustomerNotFoundException("Customer Not Found!: " + nationalId);
        }

        return true;
    }

    /**
     * Create a new Customer
     *
     * @param createCustomerDto is Customer Data-Transfer-Object Model
     * @return The created customer is returned
     */
    @Override
    public CustomerDto save(CreateCustomerDto createCustomerDto) {
        log.info(CLASS_NAME_LOG + " service save method is running.");

        String nationalId = createCustomerDto.getNationalIdNumber();

        boolean isCustomerExist = customerRepository.existsByNationalIdNumber(nationalId);

        if (isCustomerExist) {
            log.error("Customer NationalID: " + nationalId + " is already exists!");
            throw new CustomerAlreadyExistException("Customer NationalID: " + nationalId);
        }

        Customer customer = CustomerMapper.INSTANCE.mapFromCreateCustomerDtoToCustomer(createCustomerDto);
        customer.setCreatedDate(LocalDateTime.now());

        CustomerDto customerDto = CustomerMapper.INSTANCE.mapFromCustomerToCustomerDto(customerRepository.save(customer));

        log.info(customerDto.getFullName() + " is saved a new customer.");

        return customerDto;
    }

    /**
     * Update a Customer
     *
     * @param nationalId        is unique
     * @param updateCustomerDto is Customer Data-Transfer-Object Model
     * @return The updated customer is returned
     */
    @Override
    public CustomerDto update(String nationalId, UpdateCustomerDto updateCustomerDto) {
        log.info(CLASS_NAME_LOG + " service update method is running.");

        Customer customer = findByNationalIdCustomer(nationalId);
        customer.setFirstName(updateCustomerDto.getFirstName());
        customer.setLastName(updateCustomerDto.getLastName());
        customer.setPhoneNumber(updateCustomerDto.getPhoneNumber());
        customer.setMonthlyIncome(updateCustomerDto.getMonthlyIncome());
        customer.setGuarantee(updateCustomerDto.getGuarantee());
        customer.setDateOfBirth(updateCustomerDto.getDateOfBirth());

        log.info("customer update saved");

        CustomerDto customerDto = CustomerMapper.INSTANCE.mapFromCustomerToCustomerDto(customerRepository.save(customer));

        return customerDto;
    }

    /**
     * Delete a Customer
     * Deletes the customer with the National Id value
     *
     * @param nationalId is unique
     */
    @Override
    public void delete(String nationalId) {
        log.info(CLASS_NAME_LOG + " service delete method is running.");

        Customer customer = findByNationalIdCustomer(nationalId);
        customerRepository.delete(customer);

        log.info("customer has been deleted. NationalID: " + nationalId);
    }


    /**
     * @param nationalIdNumber is unique
     * @return Returns customer with unique NationalId value
     */
    private Customer findByNationalIdCustomer(String nationalIdNumber) {
        Customer customer = customerRepository.findAllByNationalIdNumber(nationalIdNumber)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found! NationalID : " + nationalIdNumber));
        log.info(nationalIdNumber + " number is find customer.");
        return customer;
    }

}

