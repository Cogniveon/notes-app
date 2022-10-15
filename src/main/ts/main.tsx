import './main.css'

import React from 'react'
import { createRoot } from 'react-dom/client'

function App() {
  return <pre>Hello, world!</pre>
}

const el = document.getElementById('app-root')

if (el == null) {
  throw new Error("Root element '#app-root' must be defined!")
} else {
  const root = createRoot(el)
  root.render(<App />)
}
