import React from 'react';
import { Route, Switch } from 'react-router-dom';
import HomePage from './pages/HomePage';
import ArticlePage from './pages/ArticlePage';
import DiscussionPage from './pages/DiscussionPage';

const App: React.FC = () => {
  return (
    <div className="App">
      <Switch>
        <Route path="/" exact component={HomePage} />
        <Route path="/article/:id" component={ArticlePage} />
        <Route path="/discussion/:id" component={DiscussionPage} />
      </Switch>
    </div>
  );
};

export default App;
