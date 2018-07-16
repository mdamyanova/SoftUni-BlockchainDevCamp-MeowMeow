import $ from 'jquery';
let baseUrl = "http://localhost:8080/";

const App = (function(){
    function loginUser(username, password) {
        return $.ajax({
            method: "POST",
            url: baseUrl + "user/login",
            data: {username, password}
        });
    }

    function registerUser(username, password) {
        return $.ajax({
            method: "POST",
            url: baseUrl + "user/register",
            data: {username, password}
        });
    }

    function logoutUser() {
        return $.ajax({
            method: "POST",
            url: baseUrl + "user/logout"
        });
    }

    function allCats() {
        return $.ajax({
            method: "GET",
            url: baseUrl + "cats/all",
        });
    }

    return {
        loginUser,
        registerUser,
        logoutUser,
        allCats
    }
})();

export default App;