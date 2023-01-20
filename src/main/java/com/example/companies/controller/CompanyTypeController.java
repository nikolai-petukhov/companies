package com.example.companies.controller;

import com.example.companies.exceptions.CompanyTypeNotFoundException;
import com.example.companies.model.CompanyType;
import com.example.companies.repository.CompanyTypeRepository;
import org.springframework.beans.BeanUtils;
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

    @GetMapping("{id}")
    public CompanyType getCompanyTypeById(@PathVariable("id") Long id) {
        return companyTypeRepository.findById(id)
                .orElseThrow(() -> new CompanyTypeNotFoundException(id));
    }

    @PostMapping()
    public CompanyType newCompanyType(@RequestBody CompanyType companyType) {
        return companyTypeRepository.save(companyType);
    }

    @PutMapping("{id}")
    public CompanyType updateCompanyType(
            @PathVariable("id") CompanyType companyTypeFromDb,
            @RequestBody CompanyType companyType
    ) {
        BeanUtils.copyProperties(companyType, companyTypeFromDb, "id");
        return companyTypeRepository.save(companyTypeFromDb);
    }


    @DeleteMapping("{id}")
    public void deleteCompanyType(@PathVariable("id") Long id) {
        companyTypeRepository.deleteById(id);
    }
}
