package com.example.companies.utils.advices;

import com.example.companies.utils.exceptions.CompanyTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CompanyTypeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CompanyTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(CompanyTypeNotFoundException exception) {
        return exception.getMessage();
    }
}
