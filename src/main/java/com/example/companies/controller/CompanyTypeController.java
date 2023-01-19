package com.example.companies.controller;

import com.example.companies.model.CompanyType;
import com.example.companies.repository.CompanyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class CompanyTypeController {

    @Autowired
    private CompanyTypeRepository companyTypeRepository;

    @GetMapping("companytype")
    public List<CompanyType> getCompanyTypeList() {
        return this.companyTypeRepository.findAll();
    }
}
