import React, { useState, useEffect } from 'react'
import companyTypeService from './services/companyType'
import companyService from './services/company'
import employeeService from './services/employee'

const App = () => {
  const [companyTypes, setCompanyTypes] = useState([])
  const [companies, setCompanies] = useState([])
  const [employees, setEmployees] = useState([])

  useEffect(() => {
    companyTypeService.getAll().then((companyTypesList) => setCompanyTypes(companyTypesList))
    companyService.getAll().then(companiesList => setCompanies(companiesList))
    employeeService.getAll().then(employeesList => setEmployees(employeesList))
  }, [])

  return (
    <>
      <h1>Company catalog</h1>
      <ul>
        {companies.map(company => <li key={company.id}>{company.name}</li>)}
      </ul>


      <h2>Company Types Catalog</h2>
      <ul>
        {companyTypes.map(companyType => <li key={companyType.id}>{companyType.typeName}</li>)}
      </ul>

      <h2>Employees Catalog</h2>
      <ul>
        {employees.map(employee => <li key={employee.id}>{employee.firstName} {employee.lastName}</li>)}
      </ul>
    </>
  )
}

export default App
