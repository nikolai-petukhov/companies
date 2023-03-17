import { Button } from "@mui/material"
import Box from '@mui/material/Box'
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';

const AddDelButtonsPanel = () => {
    return (
        <Box sx={{ '& button': { m: 1 } }}>
            <Button 
                variant="outlined" 
                endIcon={<AddCircleOutlineIcon />}
            >Add</Button>
            <Button
                variant="outlined"
                color="error"
                endIcon={<RemoveCircleOutlineIcon />}
            >Delete</Button>
        </Box>
    )
}

export default AddDelButtonsPanel