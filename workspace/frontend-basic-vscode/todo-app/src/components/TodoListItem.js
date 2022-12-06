import { MdCheckBoxOutlineBlank, MdCheckBox, MdRemoveCircleOutline } from 'react-icons/md';
const TodoListItem = (props) => {

    return (
        <div>
            <div>
                <MdCheckBoxOutlineBlank />
                <div>content</div>
            </div>
            <div>
                <MdRemoveCircleOutline />
            </div>
        </div>
    )

};

export default TodoListItem;