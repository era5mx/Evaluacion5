// Below Function Executes On Form Submit Login
function ValidationEventLogin() {
    // Storing Field Values In Variables
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // Conditions
    if (username === '' && password === '') {
        alert("Todos los campos son requeridos.....!");
        return false;
    }
    if (username === '') {
        alert("El nombre de usuario es obligatorio, si no lo recuerda \ncontacte al administrador del sistema!");
        return false;
    }
    if (password === '') {
        alert("El password es obligatorio, si no lo recuerda \ncontacte al administrador del sistema!");
        return false;
    }
    return true;

}

// Below Function Executes On Form Submit Register
function ValidationEventRegister() {
    // Storing Field Values In Variables
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var exam = document.getElementById("exam").value;
    // Regular Expression For Email
    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
    var letter = /^[a-z](\w*)[a-z0-9]$/i; ///^\w+$/;
    // Conditions
    if (username !== '' && email !== '' && password !== '' && exam !=='') {
        if (!email.match(emailReg)) {
            alert("Formato de email Invalido...!!!");
            return false;
        }
        if (!username.match(letter)) {
            alert("Error: El nombre de usuario debe comenzar con una letra \n         y solo puede contener letras, numeros y guiones bajos!");
            return false;
        }
        if (password.length < 7) {
            alert("Error: El Password debe contener al menos siete(7) caracteres!");
            return false;
        }
        if (password === username) {
            alert("Error: El Password debe ser diferente al Nombre de Usuario!");
            return false;
        }
        re = /[0-9]/;
        if (!re.test(password)) {
            alert("Error: El password debe contener al menos un numero (0-9)!");
            return false;
        }
        re = /[a-z]/;
        if (!re.test(password)) {
            alert("Error: El password debe contener al menos una letra minuscula (a-z)!");
            return false;
        }
        re = /[A-Z]/;
        if (!re.test(password)) {
            alert("Error: El password debe contener al menos una letra mayuscula (A-Z)!");
            return false;
        }
        re =/.../
        if (!re.test(exam)) {
            alert("Debe seleccionar un rol!");
            return false;
        }
        return true;
    } else {
        alert("Todos los campos son requeridos.....!");
        return false;
    }
}