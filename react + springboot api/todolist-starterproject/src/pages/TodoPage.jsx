import React, { useEffect, useState } from "react";
import InputItem from '../components/InputItem';
import TodoList from '../components/TodoList';
import axios from "axios";
import ToDoApi from "../api/ToDoApi";

function TodoPage() {

    const [todoItems, setToDoItems] = useState([]);

    const getToDos = () => {
        ToDoApi.getToDo()
        .then((data) => {
            setToDoItems(data);
        })
    }

    const addItem = title => {
        const newItem = {
            title: title
        };

        ToDoApi.createToDo(newItem)
        .then((result) => {
            console.log(result);
            getToDos();
        })
        .catch(error => console.log(error));
    }
    
    useEffect(() => {
        getToDos();
    }, [])

    return (
        <div className="container">
            <div className="inner">
                <InputItem addItem={addItem} />
                <TodoList todoItems={todoItems} />
            </div>
        </div>
    )
}

export default TodoPage;