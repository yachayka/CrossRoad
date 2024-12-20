const API_BASE_URL = 'http://localhost:8080';  // Базовый URL для API вашего бэкенда

export const fetchArticles = async () => {
  const response = await fetch(`${API_BASE_URL}/articles`);
  return response.json();
};

export const fetchDiscussions = async () => {
  const response = await fetch(`${API_BASE_URL}/discussions`);
  return response.json();
};

export const fetchArticle = async (id: number) => {
  const response = await fetch(`${API_BASE_URL}/articles/${id}`);
  return response.json();
};

export const fetchDiscussion = async (id: number) => {
  const response = await fetch(`${API_BASE_URL}/discussions/${id}`);
  return response.json();
};
