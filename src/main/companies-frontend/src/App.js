import React from 'react'

import { Container }  from '@mui/material'

import TabMenu from './components/tabMenu'
import Header from './components/header'

const App = () => {
  return (
    <>
      <Header />
      <Container maxWidth="lg">
        <TabMenu />
      </Container>
    </>
  )
}

export default App
