import React, {useEffect, useState} from 'react'
import Box from '@mui/material/Box'
import Tab from '@mui/material/Tab'
import TabContext from '@mui/lab/TabContext'
import TabList from '@mui/lab/TabList'
import TabPanel from '@mui/lab/TabPanel'
import BusinessIcon from '@mui/icons-material/Business'
import MenuBookIcon from '@mui/icons-material/MenuBook'
import { Grid } from '@mui/material'
import AddDelButtonsPanel from './addDelButtonsPanel'
import CompaniesList from './companiesTab/companiesList'
import CompanyInformationForm from './companiesTab/companyInformationForm'
import companyService from '../services/company'

const TabMenu = () => {
    const [value, setValue] = useState('1')
    const [companies, setCompanies] = useState([])
    const [selectedCompanyId, setSelectedCompanyId] = useState()

    const getSelectedCompanyIdFromList = (id) => setSelectedCompanyId(id)

    useEffect(() => {
      companyService
        .getAll()
        .then(data => {
          setCompanies(data)
        })
    }, [])

    const handleChange = (event, newValue) => {
      setValue(newValue)
    }

    if (companies.length === 0) return <h1>LOADING DATA...</h1>
    else return (
      <Box sx={{ width: '100%', typography: 'body1' }}>
        <TabContext value={value}>
          <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
            <TabList onChange={handleChange}>
              <Tab label="Companies" value="1" icon={<BusinessIcon />} iconPosition="start"/>
              <Tab label="Catalogs" value="2" icon={<MenuBookIcon />} iconPosition="start"/>
            </TabList>
          </Box>
          <TabPanel value="1">
            <Grid container spacing={2}>
              <Grid item xs={4}>
                <AddDelButtonsPanel />
                <CompaniesList companies={companies} getSelectedCompanyIdFromList={getSelectedCompanyIdFromList}/>
              </Grid>
              <Grid item xs={8}>
                {
                  selectedCompanyId
                    ? <CompanyInformationForm company={companies.find(company => company.id === selectedCompanyId)} />
                    : <h1>Please choose company from the list</h1>
                }
              </Grid>
            </Grid>
          </TabPanel>
          <TabPanel value="2">Catalogs</TabPanel>
        </TabContext>
      </Box>
    )
}

export default TabMenu