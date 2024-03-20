import React, { useState } from 'react'

export default function InputItem(props) {
    const [title, setTitle] = useState("dummyTitle");

    const handleSubmit = (event) => {
        event.preventDefault();
        props.addItem(title);
    }

    const changeText = (event) => {
        setTitle(event.target.value);
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type='text' onChange={changeText}></input>
                <button>submit</button>
            </form>
        </div>
    )
}
