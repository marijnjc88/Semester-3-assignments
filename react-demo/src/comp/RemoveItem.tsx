import React, {useState} from 'react'

export default function RemoveItem(props) {
    const [index, setIndex] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const itemIndex = parseInt(index, 10);
        if (!isNaN(itemIndex)) {
            props.removeItem(itemIndex);
            setIndex('');
        }
    };

    const changeIndex = (event) => {
        setIndex(event.target.value);
    }

  return (
    <div>
      <form onSubmit={handleSubmit} id='remove-form'>
        <input type='number' onChange={changeIndex}></input>
        <button>submit</button>
      </form>
    </div>
  )
}
