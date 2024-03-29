import React, { useState } from "react"

function InputItem(props) {

    const [title, setTitle] =
        useState("dummyTitle");

    const handleSubmit = e => {
        // required to prevent standard behaviour of submitting
        e.preventDefault();

        // Note: The list is in TodoPage.js!
        props.addItem(title);
    }

    const textChanged = e => {
        setTitle(e.target.value);
    }

    return (
        <form className="form-container"
            onSubmit={handleSubmit}>
            <input
                type="text"
                className="input-text"
                placeholder="Add item"
                onChange={textChanged}
            />
            <button className="input-submit">Submit</button>
        </form>
    )
}

export default InputItem;