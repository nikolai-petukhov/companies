package com.example.companies.utils.exceptions;

public class CompanyNotFoundException  extends RuntimeException {
    public CompanyNotFoundException(Long id) {
        super("Could not find company with id:" + id);
    }
}
