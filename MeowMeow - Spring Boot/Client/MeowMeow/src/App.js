import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import './App.css';

// Main
import NavigationBar from './components/NavigationBar';
import Footer from './components/Footer';
import HomeView from './views/HomeView';
import AboutView from './views/AboutView';

// User
import LoginView from './views/users/LoginView';
import RegisterView from './views/users/RegisterView';

// Cats
import CatsView from './views/cats/CatsView';
import AddCatView from './views/cats/AddCatView';
import CatProfileView from './views/cats/CatProfileView';

import Requests from './Requests';
import $ from 'jquery';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: sessionStorage.getItem("username"),
            userId: sessionStorage.getItem("userId")
        };
    }

    render() {
        return (
            <div className="App">
                <header>
                    <NavigationBar
                        username={this.state.username}
                        homeClicked={this.showHomeView.bind(this)}
                        aboutClicked={this.showAboutView.bind(this)}
                        loginClicked={this.showLoginView.bind(this)}
                        registerClicked={this.showRegisterView.bind(this)}
                        logoutClicked={this.logout.bind(this)}
                        allCatsClicked={this.showCatsView.bind(this)}
                        addCatClicked={this.showAddCatView.bind(this)}
                        profileCatClicked={this.showCatProfileView.bind(this)}
                    />
                    <div id="loadingBox">Loading ...</div>
                    <div id="infoBox">Info</div>
                    <div id="errorBox">Error</div>
                </header>
                <main id="main">

                </main>
                <Footer/>
            </div>
        );
    }

    componentDidMount() {
        // Attach global AJAX "loading" event handlers
        $(document).on({
            ajaxStart: function () {
                $("#loadingBox").show()
            },
            ajaxStop: function () {
                $("#loadingBox").hide()
            }
        });

        // Attach a global AJAX error handler
        $(document).ajaxError(this.handleAjaxError.bind(this));

        // Hide the info / error boxes when clicked
        $("#infoBox, #errorBox").click(function () {
            $(this).fadeOut();
        });

        // Initially load the "Home" view when the app starts
        this.showHomeView();
    }

    handleAjaxError(event, response) {
        let errorMsg = JSON.stringify(response);
        if (response.readyState === 0)
            errorMsg = "Cannot connect due to network error.";
        if (response.responseJSON && response.responseJSON.description)
            errorMsg = response.responseJSON.description;
        this.showError(errorMsg);
    }

    showView(reactViewComponent) {
        ReactDOM.render(reactViewComponent,
            document.getElementById('main'));
        $('#errorBox').hide();
    }

    showInfo(message) {
        $('#infoBox').text(message).show();
        setTimeout(function () {
            $('#infoBox').fadeOut();
        }, 3000);
    }

    showError(errorMsg) {
        $('#errorBox').text("Error: " + errorMsg).show();
    }

    showHomeView() {
        this.showView(<HomeView username={this.state.username}/>);
    }

    showAboutView() {
        this.showView(<AboutView/>);
    }

    showLoginView() {
        this.showView(<LoginView onsubmit={this.login.bind(this)}/>);
    }

    showRegisterView() {
        this.showView(<RegisterView onsubmit={this.register.bind(this)}/>);
    }

    // TODO
    showCatsView() {
        this.showView(<CatsView/>);
    }

    // TODO
    showAddCatView() {
        this.showView(<AddCatView/>)
    }

    // TODO
    showCatProfileView() {
        this.showView(<CatProfileView/>);
    }

    login(username, password) {
        Requests.loginUser(username, password)
            .then(loginSuccess.bind(this));

        function loginSuccess(userInfo) {
            this.saveAuthInSession(userInfo);
            this.showHomeView();
            this.showInfo("Login successful.");
        }
    }

    register(username, password) {
        Requests.registerUser(username, password)
            .then(registerSuccess.bind(this));

        function registerSuccess(userInfo) {
            this.saveAuthInSession(userInfo);
            this.showHomeView();
            this.showInfo("User registration successful.");
        }
    }

    logout() {
        Requests.logoutUser();
        sessionStorage.clear();
        this.setState({username: null, userId: null});
        this.showHomeView();
        this.showInfo('Logout successful.');
    }

    saveAuthInSession(userInfo) {
        sessionStorage.setItem('username', userInfo.username);

        // This will update the entire app UI (e.g. the navigation bar)
        this.setState({
            username: userInfo.username,
        });
    }

    showMyMessagesView() {
        Requests.allCats()
            .then(loadCatsSuccess.bind(this));

        function loadCatsSuccess(cats) {
            this.showInfo("Cats loaded.");
            this.showView(
                <CatsView
                    cats={cats}
                />
            );
        }
    }
}

export default App;