package com.example.companies.controller;

import com.example.companies.model.Company;
import com.example.companies.repository.CompanyRepository;
import com.example.companies.utils.exceptions.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping()
    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }

    @GetMapping("{id}")
    public Company getCompanyById(@PathVariable("id") Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }
}
