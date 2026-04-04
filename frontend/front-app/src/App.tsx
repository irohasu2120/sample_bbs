import { Route, Routes } from 'react-router-dom';
// import './App.css';
import Sample from './pages/sample.tsx';

function App() {
  return (
    <Routes>
      <Route path={'/'} element={<Sample />} />
    </Routes>
  );
}

export default App;
