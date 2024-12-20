import React, { useEffect, useState } from 'react';
import { getArticles } from '../api/api';

const ArticleList: React.FC = () => {
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        getArticles().then(setArticles);
    }, []);

    return (
        <div>
            {articles.map((article: any) => (
                <div key={article.id}>
                    <h3>{article.title}</h3>
                    <p>{article.content}</p>
                </div>
            ))}
        </div>
    );
};

export default ArticleList;
