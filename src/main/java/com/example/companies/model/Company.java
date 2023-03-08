package com.example.companies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private long numberOfEmployee;
    private String additionalInformation;
    private long foundingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_type_id")
    private CompanyType companyType;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Company(
            String name,
            String description,
            String address,
            String phoneNumber,
            long numberOfEmployee,
            String additionalInformation,
            long foundingDate
    ) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.numberOfEmployee = numberOfEmployee;
        this.additionalInformation = additionalInformation;
        this.foundingDate = foundingDate;
    }
}