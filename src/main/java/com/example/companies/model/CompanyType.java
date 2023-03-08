package com.example.companies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "companyType", fetch = FetchType.LAZY)
    private List<Company> companies;

    public CompanyType(String typeName) {
        this.typeName = typeName;
    }
}
