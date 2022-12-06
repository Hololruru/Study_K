import { useState } from 'react';

import logo from './logo.svg';
import './App.css';
import TodoTemplate from './components/TodoTemplate';
import TodoList from './components/TodoList';
import TodoInsert from './components/TodoInsert';

function App() {

  // const [ todos, setTodos ] = useState([
  //   { id: 1, title: '스프링 웹 프로젝트', checked: true },
  //   { id: 2, title: '프론트엔드 웹 프로젝트', checked: false },
  //   { id: 3, title: '파이썬 프로젝트', checked: true },
  // ]);
  const [ todos, setTodos ] = useState([]);
  const [ nextId, setNextId ] = useState(1);

  const insertTodo = (title) => {
    const todo = { id: nextId, title: title, checked: false }
    const newTodos = todos.concat(todo);
    setTodos(newTodos);
    setNextId(nextId  + 1); 
  };

  const toggleTodoChecked = (id) => {

    setTodos(
      // todos.map( (todo) => todo.id === id ? { id: todo.id, title: todo.title, checked: !todo.checked } : todo );
      todos.map( (todo) => todo.id === id ? { ...todo, checked: !todo.checked } : todo )
    )

  }

  return (
    <div>
      <TodoTemplate>
        <TodoInsert onInsert={ insertTodo } />
        <TodoList todos={ todos }
                  onToggle={ toggleTodoChecked }
        ></TodoList>
      </TodoTemplate>
    </div>
  );
}

export default App;
