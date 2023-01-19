package com.example.companies;

import com.example.companies.model.CompanyType;
import com.example.companies.repository.CompanyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompaniesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CompaniesApplication.class, args);
    }

    @Autowired
    private CompanyTypeRepository companyTypeRepository;

    @Override
    public void run(String...args) throws Exception {
        this.companyTypeRepository.save(new CompanyType("Private Company"));
        this.companyTypeRepository.save(new CompanyType("Public Company"));
        this.companyTypeRepository.save(new CompanyType("Unlimited Company"));
        this.companyTypeRepository.save(new CompanyType("One Person Company"));
    }

}
