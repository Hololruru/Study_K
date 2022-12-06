import './TodoList.scss';
import TodoListItem from './TodoListItem';

// const TodoList = (props) => {
//     const { todos } = props;
const TodoList = ({ todos }) => {

    return (
        <div className="TodoList">
            {
                todos.map( (todo) => {
                    return <TodoListItem key={todo.id} todo={ todo } />
                })                
            }
        </div>
    );

};

export default TodoList;