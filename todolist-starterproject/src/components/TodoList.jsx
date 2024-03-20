import React from "react"
import TodoItem from './TodoItem';

function TodoList(props) {
  const handleDelete = (id) => {
    props.onDelete(id);
  };

  const handleCheck = (id) => {
    props.onCheck(id);
  }

  return (
    <ul>
      {props.todoItems.map(todoItem => (
        <TodoItem
          key = {todoItem.id}
          todoItem = {todoItem}
          onDelete = {handleDelete}
          onCheck = {handleCheck}
        />
      ))}
    </ul>
  )
}

export default TodoList;