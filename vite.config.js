import react from '@vitejs/plugin-react'
import { defineConfig } from 'vite'
import viteCompression from 'vite-plugin-compression'

// https://vitejs.dev/config/
// export default defineConfig({
//   build: { manifest: true },
//   base: process.env.mode === 'production' ? '/static/' : '/',
//   root: './web',
//   plugins: [react(), viteCompression()],
// })
export default defineConfig({
  build: {
    outDir: '../../../build/ts',
    emptyOutDir: true,
    assetsDir: 'static',
    // generate manifest.json in outDir
    manifest: true,
    rollupOptions: {
      // overwrite default .html entry
      input: './src/main/ts/main.tsx',
    },
  },
  root: './src/main/ts',
  base: process.env.mode === 'production' ? '/static/' : '/',
  plugins: [react(), viteCompression()],
})
