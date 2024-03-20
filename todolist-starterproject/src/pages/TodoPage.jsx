import React, { useState } from "react";
import InputItem from '../components/InputItem';
import TodoList from '../components/TodoList';

function TodoPage() {

    // This data is only present for demo purposes. Usually you obtain this through the backend.
    const todoItemsData = [
        {
            id: 1,
            title: "Do groceries",
            done: true
        },
        {
            id: 2,
            title: "Clean bathroom",
            done: false
        },
        {
            id: 3,
            title: "Dispose thrash",
            done: true
        },
    ]

    const [id, setId] = useState(4);
    const [todoItems, setToDoItems] = useState(todoItemsData);

    const addItem = title => {
        const newItem = {
            id: id,
            title: title,
            done: false
        };
        setId(id + 1);
        setToDoItems([...todoItems, newItem]);
    }

    const deleteItem = id => {
        const updatedItems = todoItems.filter((item) => item.id !== id);
        setToDoItems(updatedItems);
    }

    const handleCheck = (id) => {
        const updatedItems = todoItems.map((item) =>
            item.id === id ? { ...item, done: !item.done } : item
        );
        setToDoItems(updatedItems);
    }

    const completedTasks = todoItems.filter(item => item.done).length;
    const totalTasks = todoItems.length;
    const percentage = totalTasks > 0 ? (completedTasks / totalTasks) * 100 : 100;

    return (
        <div className="container">
            <div className="inner">
                <InputItem
                    addItem = {addItem}
                />
                <div>
                    {totalTasks === 0 ? (
                        <p>There are no tasks</p>
                    ) : (
                        <p>Tasks completed: {completedTasks}/{totalTasks}, {percentage.toFixed(1)}%</p>
                    )}
                </div>
                <TodoList
                    todoItems = {todoItems}
                    onDelete = {deleteItem}
                    onCheck = {handleCheck}
                />
            </div>
        </div>
    )
}

export default TodoPage;