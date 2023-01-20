package com.example.companies.controller;

import com.example.companies.exceptions.CompanyTypeNotFoundException;
import com.example.companies.model.CompanyType;
import com.example.companies.repository.CompanyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/companytype")
public class CompanyTypeController {

    @Autowired
    private CompanyTypeRepository companyTypeRepository;

    @GetMapping()
    public List<CompanyType> getCompanyTypeList() {
        return this.companyTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public CompanyType getCompanyTypeById(@PathVariable("id") Long id) {
        return companyTypeRepository.findById(id)
                .orElseThrow(() -> new CompanyTypeNotFoundException(id));
    }
}
