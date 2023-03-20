import ListItemButton from '@mui/material/ListItemButton'
import ListItemText from '@mui/material/ListItemText'
import Divider from '@mui/material/Divider'

const CompaniesListItem = ({ company, selectedIndex, selectItemHanler }) => {
    return (
        <>
        <ListItemButton
            selected={selectedIndex === company.id}
            onClick={(event) => selectItemHanler(event, company.id)}
        >
            <ListItemText primary={company.name} />
        </ListItemButton>
         <Divider />
         </>
    )
}

export default CompaniesListItem