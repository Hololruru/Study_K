import { MdCheckBoxOutlineBlank, MdCheckBox, MdRemoveCircleOutline } from 'react-icons/md';
import './TodoListItem.scss';

const TodoListItem = ({ todo, onToggle }) => {

    const { id, title, checked } = todo;

    return (
        <div className="TodoListItem">
            <div className="checkbox"
                 onClick={ (e) => { onToggle(id); } }
            >
                {
                    checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />
                }
                <div className="text">{ title }</div>
            </div>
            <div className="remove">
                <MdRemoveCircleOutline />
            </div>
        </div>
    )

};

export default TodoListItem;