package com.example.companies.model;

import javax.persistence.*;

@Entity
@Table(name = "company_type")
public class CompanyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type_name")
    private String typeName;

    public CompanyType() {
    }

    public CompanyType(String typeName) {
        this.typeName = typeName;
    }

    public CompanyType(long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "CompanyType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
