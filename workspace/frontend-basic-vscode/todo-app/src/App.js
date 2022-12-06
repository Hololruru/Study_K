import logo from './logo.svg';
import './App.css';
import TodoTemplate from './components/TodoTemplate';
import TodoList from './components/TodoList';

function App() {
  return (
    <div>
      <TodoTemplate>
        <TodoList></TodoList>
      </TodoTemplate>
    </div>
  );
}

export default App;
