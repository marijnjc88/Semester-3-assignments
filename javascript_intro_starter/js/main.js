// An array of objects, which each represent a user account
const userAccounts = [
    {
        username: 'john@example.com',
        password: 'john'
    },
    {
        username: 'sarah@example.com',
        password: 'sarah'
    },
    {
        username: 'hector@example.com',
        password: 'hector'
    }
];

console.log('The user accounts have been initialised!');

const form = document.getElementById("login-form");

function tryLogin(event) {
    const username = document.getElementById("login-input-username").value;
    const password = document.getElementById("login-input-password").value;

    const userExists = userAccounts.find(user => user.username === username && user.password === password);

    if (userExists) {
        console.log('Login successful');
    }
    else {
        console.log('Login failed');
    }

    event.preventDefault();
}

function clearFields(event) {
    form.reset();

    event.preventDefault();
}

function logUsers(event) {
    userAccounts.map(user => user.username).forEach((e) => console.log(e));

    event.preventDefault();
}

form.addEventListener("submit", (e) => tryLogin(e));
const clearButton = document.getElementById("login-button-clear");
clearButton.addEventListener("click", (e) => clearFields(e));
const logUsersButton = document.getElementById("login-button-log-usernames");
logUsersButton.addEventListener("click", (e) => logUsers(e));
