import { useState } from 'react';

import logo from './logo.svg';
import './App.css';
import TodoTemplate from './components/TodoTemplate';
import TodoList from './components/TodoList';

function App() {

  const [ todos, setTodos ] = useState([
    { id: 1, title: '스프링 웹 프로젝트', checked: true },
    { id: 2, title: '프론트엔드 웹 프로젝트', checked: false },
    { id: 3, title: '파이썬 프로젝트', checked: true },
  ]);

  return (
    <div>
      <TodoTemplate>
        <TodoList todos={ todos }></TodoList>
      </TodoTemplate>
    </div>
  );
}

export default App;
