import React, {useState} from 'react';
import Box from '@mui/material/Box';
import Tab from '@mui/material/Tab';
import TabContext from '@mui/lab/TabContext';
import TabList from '@mui/lab/TabList';
import TabPanel from '@mui/lab/TabPanel';
import BusinessIcon from '@mui/icons-material/Business';
import MenuBookIcon from '@mui/icons-material/MenuBook';
import { Grid } from '@mui/material';
import AddDelButtonsPanel from './addDelButtonsPanel';
import CompaniesList from './companiesList';
import CompanyInformationForm from './companyInformationForm';

const TabMenu = () => {
    const [value, setValue] = useState('1')

    const handleChange = (event, newValue) => {
      setValue(newValue)
    }

    return (
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
                <CompaniesList />
              </Grid>
              <Grid item xs={8} style={{backgroundColor: '#e3f2fd'}}>
                <CompanyInformationForm />
              </Grid>
            </Grid>
          </TabPanel>
          <TabPanel value="2">Catalogs</TabPanel>
        </TabContext>
      </Box>
    )
}

export default TabMenu