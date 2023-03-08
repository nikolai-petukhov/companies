package com.example.companies;

import com.example.companies.model.Company;
import com.example.companies.model.CompanyType;
import com.example.companies.model.Employee;
import com.example.companies.repository.CompanyRepository;
import com.example.companies.repository.CompanyTypeRepository;
import com.example.companies.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class CompaniesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CompaniesApplication.class, args);
    }

    @Autowired
    private CompanyTypeRepository companyTypeRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void run(String...args) throws Exception {
//
        this.companyTypeRepository.save(new CompanyType("Private Company"));
        this.companyTypeRepository.save(new CompanyType("Public Company"));
        this.companyTypeRepository.save(new CompanyType("Unlimited Company"));
        this.companyTypeRepository.save(new CompanyType("One Person Company"));



        this.employeeRepository.save(new Employee("John", "Doe"));
        this.employeeRepository.save(new Employee("Elton", "John"));
        this.employeeRepository.save(new Employee("David", "Jackson"));
        this.employeeRepository.save(new Employee("Nicolas", "Cage"));




        CompanyType superCompany = new CompanyType("Super Company");
        Employee superEmployee = new Employee("Super", "Employee");
        this.companyTypeRepository.save(superCompany);

        this.companyRepository.save(new Company(
                "Company Name",
                "Company Description",
                "Company Address",
                "+375-29-810-27-78",
                2,
                "Company additional Information",
                new Date().getTime()
        ));
    }

}
