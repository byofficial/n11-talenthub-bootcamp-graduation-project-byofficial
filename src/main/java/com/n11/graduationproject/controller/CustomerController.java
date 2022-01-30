package com.n11.graduationproject.controller;

import com.n11.graduationproject.dto.request.CreateCustomerDto;
import com.n11.graduationproject.dto.request.UpdateCustomerDto;
import com.n11.graduationproject.dto.response.CustomerDto;
import com.n11.graduationproject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll() {
        List<CustomerDto> customerDtoList = customerService.findAll();
        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }

    @GetMapping("/{nationalId}")
    public ResponseEntity<CustomerDto> findByNationalId(@PathVariable String nationalId) {
        CustomerDto customerDto = customerService.findByNationalId(nationalId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody @Valid CreateCustomerDto createCustomerDto) {
        CustomerDto customerDto = customerService.save(createCustomerDto);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PutMapping("/{nationalId}")
    public ResponseEntity<CustomerDto> update(@PathVariable String nationalId, @RequestBody @Valid UpdateCustomerDto updateCustomerDto) {
        CustomerDto customerDto = customerService.update(nationalId, updateCustomerDto);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{nationalId}")
    public ResponseEntity<String> delete(@PathVariable String nationalId) {
        customerService.delete(nationalId);
        return new ResponseEntity<>("Delete Customer! National ID: " + nationalId, HttpStatus.OK);
    }

}
