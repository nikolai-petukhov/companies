package com.example.companies.utils.exceptions;

public class CompanyTypeNotFoundException extends RuntimeException {
    public CompanyTypeNotFoundException(Long id) {
        super("Could not find company type with id:" + id);
    }
}
