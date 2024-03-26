import axios from "axios";

const base_url = "http://localhost:8080";
const todos_endpoint = "/todos";

const ToDoApi = {
    getToDo : () => axios.get(base_url + todos_endpoint)
        .then((response) => response.data.todos)
        .catch(error => console.log(error)),
    createToDo : (newItem) => axios.post(base_url + todos_endpoint, newItem)
        .then((response) => response.data.id)
        .catch(error => console.log(error))
}

export default ToDoApi