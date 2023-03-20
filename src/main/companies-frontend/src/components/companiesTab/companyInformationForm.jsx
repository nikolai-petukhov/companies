import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs'
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider'
import { DatePicker } from '@mui/x-date-pickers/DatePicker'
import { Divider, Grid, TextField, InputAdornment, IconButton, Button } from '@mui/material'
import MoreHorizIcon from '@mui/icons-material/MoreHoriz'
import dayjs from 'dayjs'

const CompanyInformationForm = ({ company }) => {

    //create new method
    // update method

    const handleSubmit = (event) => {

        event.preventDefault();
    }

    return (
        
        <form onSubmit={handleSubmit}>
            <TextField 
                fullWidth 
                size="small" 
                margin="normal" 
                id="company-name" 
                label="Company Name" 
                variant="outlined" 
                value={company.name}
            />

            <Grid container spacing={2}>
                <Grid item xs={6}>
                    <TextField 
                        fullWidth 
                        multiline 
                        rows={4} 
                        size="small" 
                        margin="normal" 
                        id="description" 
                        label="Description" 
                        variant="outlined"
                        value={company.description}
                    />
                </Grid>
                <Grid item xs={6}>
                    <TextField 
                        fullWidth 
                        size="small" 
                        margin="normal" 
                        id="address" 
                        label="Address" 
                        variant="outlined"
                        value={company.address}
                    />
                    <TextField 
                        fullWidth 
                        size="small" 
                        margin="normal" 
                        id="phone-number" 
                        label="Phone Number" 
                        variant="outlined" 
                        value={company.phoneNumber}
                    />
                </Grid>
            </Grid>

            <TextField 
                type="number" 
                size="small" 
                margin="normal" 
                id="number-of-employee" 
                label="Number Of Employee" 
                variant="outlined" 
                value={company.numberOfEmployee}
            />

            <TextField 
                fullWidth 
                multiline 
                rows={4} 
                size="small" 
                margin="normal" 
                id="additional-information" 
                label="Additional Information"
                variant="outlined"
                value={company.additionalInformation}
            />
            <Divider style={{margin: 15, border: "solid 1px grey"}}/>
            
            <Grid container spacing={2}>
                <Grid item xs={6}>
                    <TextField 
                        fullWidth 
                        size="small" 
                        margin="normal" 
                        id="company-type" 
                        label="Company Type" 
                        variant="outlined"
                        InputProps={{endAdornment: (
                            <InputAdornment position="end">
                                <IconButton edge="end" color="primary">
                                    <MoreHorizIcon />
                                </IconButton>
                            </InputAdornment>
                            ),
                            readOnly: true
                        }}
                        value={company.companyType ? company.companyType.typeName : ''}
                    />
                </Grid>
                <Grid item xs={6}></Grid>
                <Grid item xs={6}>
                    <TextField 
                        fullWidth 
                        size="small" 
                        margin="normal" 
                        id="manager" 
                        label="Manager" 
                        variant="outlined"
                        InputProps={{
                            endAdornment: (
                                <InputAdornment position="end">
                                    <IconButton edge="end" color="primary">
                                        <MoreHorizIcon />
                                    </IconButton>
                                </InputAdornment>
                            ),
                            readOnly: true
                        }}
                        value={company.employee ? company.employee.firstName + " " + company.employee.lastName : ''}
                    />
                </Grid>
                <Grid item xs={6}>
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <DatePicker 
                            label="Founding Date" 
                            slotProps={{
                                textField: {size:'small',
                                margin: "normal",
                                fullWidth: true
                            }}}
                            value={dayjs(company.foundingDate)}
                        />
                    </LocalizationProvider>
                </Grid>
            </Grid>
            <Button 
                fullWidth 
                variant="contained" 
                sx={{marginTop: 2}}
                type="submit"
            >Save</Button>
        </form>
    )
}

export default CompanyInformationForm