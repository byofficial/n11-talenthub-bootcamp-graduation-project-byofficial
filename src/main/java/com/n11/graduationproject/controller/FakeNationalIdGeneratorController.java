package com.n11.graduationproject.controller;

import com.n11.graduationproject.service.IFakeNationalIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@CrossOrigin
@RequestMapping("/api/generate-id")
public class FakeNationalIdGeneratorController {
    private final IFakeNationalIdGenerator fakeNationalIdGenerator;

    @Autowired
    public FakeNationalIdGeneratorController(IFakeNationalIdGenerator fakeNationalIdGenerator) {
        this.fakeNationalIdGenerator = fakeNationalIdGenerator;
    }

    @GetMapping
    public ResponseEntity<String> generateID() {
        String nationalIdNumber = fakeNationalIdGenerator.generateNationalIdNumber();
        return new ResponseEntity<>(nationalIdNumber, HttpStatus.OK);
    }

}
