import React from "react"
import styles from "./TodoItem.module.css"

function TodoItem(props) {
    const handleDelete = () => {
        props.onDelete(props.todoItem.id);
    };

    const handleCheck = () => {
        props.onCheck(props.todoItem.id);
    }

    return (
        <li className={styles.item}>
            <input
                type = "checkbox"
                checked = {props.todoItem.done}
                onChange = {handleCheck}
            />
            {props.todoItem.title}
            <div>
                <button onClick={handleDelete}>Delete</button>
            </div>
        </li>
    )
}

export default TodoItem;