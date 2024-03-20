import { useEffect, useState } from 'react'
import './App.css'
import HelloPanel from './comp/HelloPanel'
import ToDoList from './comp/ToDoList'
import axios from 'axios';
import InputItem from './comp/InputItem';
import RemoveItem from './comp/RemoveItem';

function App() {
  const [name, setName] = useState("World");

  const freshName = async () => {
      axios.get('https://randomuser.me/api/')
      .then(rest => setName(rest.data.results[0].name.last)
      )
  }

  useEffect(() => {
      freshName();
  }, [])

  const [toDos, setToDos] = useState([
      'item1',
      'item2',
      'item3'
  ]);

  const addItem = (item) => {
      setToDos([...toDos, item])
  }

  const removeItem = (index) => {
      const updatedToDos = [...toDos];
      updatedToDos.splice(index, 1);
      setToDos(updatedToDos);
  }

  return (
    <>
      <HelloPanel name = {name} />
      
      <div>Add item</div>
      <InputItem addItem = {addItem}/>
      <p></p>
      <div>Remove item by index</div>
      <RemoveItem removeItem = {removeItem}/>
      <p></p>
      <div>ToDo list</div>
      <ToDoList todos = {toDos}/>
    </>
  )
}

export default App

// `npm run test` to run application