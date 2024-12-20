import React, { useEffect, useState } from 'react';
import { fetchArticles, fetchDiscussions } from '../services/api';

const HomePage: React.FC = () => {
  const [articles, setArticles] = useState<any[]>([]);
  const [discussions, setDiscussions] = useState<any[]>([]);

  useEffect(() => {
    fetchArticles().then(setArticles);
    fetchDiscussions().then(setDiscussions);
  }, []);

  return (
    <div>
      <h1>Articles</h1>
      <ul>
        {articles.map((article) => (
          <li key={article.id}>{article.title}</li>
        ))}
      </ul>
      <h1>Discussions</h1>
      <ul>
        {discussions.map((discussion) => (
          <li key={discussion.id}>{discussion.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default HomePage;
