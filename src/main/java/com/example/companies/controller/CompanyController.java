package com.example.companies.controller;

import com.example.companies.model.Company;
import com.example.companies.repository.CompanyRepository;
import com.example.companies.utils.exceptions.CompanyNotFoundException;
import org.springframework.beans.BeanUtils;
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

    @PostMapping()
    public Company newCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping("{id}")
    public Company updateCompany(
            @PathVariable("id") Company companyFromDb,
            @RequestBody Company company
    ) {
        BeanUtils.copyProperties(company, companyFromDb, "id");
        return companyRepository.save(companyFromDb);
    }


    @DeleteMapping("{id}")
    public void deleteCompany(@PathVariable("id") Long id) {
        companyRepository.deleteById(id);
    }
}
