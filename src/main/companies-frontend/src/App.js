import React, { useState, useEffect } from 'react'
import companyTypeService from './services/companyType'

const App = () => {
  const [companyTypes, setcompanyTypes] = useState([])

  useEffect(() => {
    companyTypeService.getAll().then((compTypes) => setcompanyTypes(compTypes))
  }, [])

  return (
    <>
      <h1>Company Types Catalog</h1>
      <ul>
        {companyTypes.map(companyType => <li key={companyType.id}>{companyType.typeName}</li>)}
      </ul>
    </>
  )
}

export default App
