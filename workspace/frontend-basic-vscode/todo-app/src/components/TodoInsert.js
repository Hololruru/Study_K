import "./TodoInsert.scss";
import { MdAdd } from 'react-icons/md';

const TodoInsert = (props) => {

    return (
        <form className="TodoInsert">
            <input type="text"                   
            ></input>
            <button type="submit">
                <MdAdd />
            </button>
        </form>
    );

};

export default TodoInsert;