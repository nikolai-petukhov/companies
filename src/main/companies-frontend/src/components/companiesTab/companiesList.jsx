import React, {useState} from 'react'

import Box from '@mui/material/Box'
import List from '@mui/material/List'
import CompaniesListItem from './companiesListItem'


const CompaniesList = ({ companies, getSelectedCompanyIdFromList }) => {

  const [selectedIndex, setSelectedIndex] = useState()

  const handleListItemClick = (event, index) => {
      setSelectedIndex(index)
      getSelectedCompanyIdFromList(index)
  }


  return (
    <Box
      sx={{
        width: '100%',
        height: 570,
        maxWidth: 360,
        bgcolor: 'background.paper',
        overflow: 'auto'
      }}
    >
      <List component="nav" sx={{ overflow: 'auto' }}>
        {
          companies.map(
            company => <CompaniesListItem 
                          key={company.id} 
                          company={company} 
                          selectedIndex={selectedIndex} 
                          selectItemHanler={handleListItemClick}
                        />
          )
        }
      </List>
    </Box>
  )
}

export default CompaniesList
