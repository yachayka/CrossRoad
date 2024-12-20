import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';  // Ваши стили
import App from './App'; // Основной компонент приложения
import { BrowserRouter as Router } from 'react-router-dom';

ReactDOM.render(
  <Router>
    <App />
  </Router>,
  document.getElementById('root')
);
