import React from 'react'
import ToDoItem from './ToDoItem'

export default function ToDoList(props) {
    return (
        <div>
            <p></p>
            Amount of ToDos: {props.todos.length}

            <ul>
                {
                    props.todos.map((item, index) => (
                        <ToDoItem key = {index} index = {index} item = {item}/>

                    ))
                }
            </ul>
        </div>
    )
}