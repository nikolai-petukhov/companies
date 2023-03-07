package com.example.companies.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company_type")
    private List<Company> companies;

    public CompanyType(String typeName) {
        this.typeName = typeName;
    }
}
