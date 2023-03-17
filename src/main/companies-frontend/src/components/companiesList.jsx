import React, {useState} from 'react'
import Box from '@mui/material/Box'
import List from '@mui/material/List'
import ListItemButton from '@mui/material/ListItemButton'
import ListItemText from '@mui/material/ListItemText'
import Divider from '@mui/material/Divider'

const CompaniesList = () => {
  const [selectedIndex, setSelectedIndex] = useState(1)

  const handleListItemClick = (event, index) => {
    setSelectedIndex(index)
  }

  return (
    <Box
      sx={{
        width: '100%',
        height: 600,
        maxWidth: 360,
        bgcolor: 'background.paper',
        overflow: 'auto'
      }}
    >
      <List component="nav" sx={{ overflow: 'auto' }}>
        <ListItemButton
          selected={selectedIndex === 2}
          onClick={(event) => handleListItemClick(event, 2)}
        >
          <ListItemText primary="Company #1" />
        </ListItemButton>
        <Divider />
        <ListItemButton
          selected={selectedIndex === 3}
          onClick={(event) => handleListItemClick(event, 3)}
        >
          <ListItemText primary="Company #2" />
        </ListItemButton>
        <Divider />
      </List>
    </Box>
  )
}

export default CompaniesList
