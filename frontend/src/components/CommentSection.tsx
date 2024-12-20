import React, { useEffect, useState } from 'react';
import { getComments, createComment } from '../api/api';

interface Comment {
    id: number;
    articleId: number;
    userId: number;
    content: string;
}

interface CommentSectionProps {
    articleId: number;
}

const CommentSection: React.FC<CommentSectionProps> = ({ articleId }) => {
    const [comments, setComments] = useState<Comment[]>([]);
    const [content, setContent] = useState('');

    useEffect(() => {
        getComments(articleId).then(setComments);
    }, [articleId]);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        await createComment({ articleId, content });
        setContent('');
        getComments(articleId).then(setComments);  // Refresh comments
    };

    return (
        <div>
            <h2>Комментарии</h2>
            <form onSubmit={handleSubmit}>
                <textarea
                    value={content}
                    onChange={(e) => setContent(e.target.value)}
                    placeholder="Напишите ваш комментарий"
                />
                <button type="submit">Отправить</button>
            </form>
            <div>
                {comments.map((comment) => (
                    <div key={comment.id}>
                        <p>{comment.content}</p>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default CommentSection;
