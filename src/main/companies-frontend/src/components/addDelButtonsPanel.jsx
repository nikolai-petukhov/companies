import { Button } from "@mui/material"
import Box from '@mui/material/Box'
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';

const AddDelButtonsPanel = () => {
    return (
        <Box sx={{marginTop: 1,'& button': { m: 1 }, display: "flex", justifyContent: "space-between" }}>
            <Button 
                variant="outlined" 
                endIcon={<AddCircleOutlineIcon />}
                fullWidth
            >Add</Button>
            <Button
                variant="outlined"
                color="error"
                endIcon={<RemoveCircleOutlineIcon />}
                fullWidth
            >Delete</Button>
        </Box>
    )
}

export default AddDelButtonsPanel