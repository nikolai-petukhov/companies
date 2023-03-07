package com.example.companies.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

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
    private Date foundingDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "company_type_id", nullable = false)
    private CompanyType companyType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private HashSet<Employee> employees;
}
