import React from 'react'

export default function ToDoItem(props) {
    return (
        <div>
            { props.index } { props.item }
        </div>
    )
}