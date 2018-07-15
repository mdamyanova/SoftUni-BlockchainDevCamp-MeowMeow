if (typeof web3 === 'undefined') {
    let warningDiv = document.getElementById('metamask-warning');
    // Showing an Error
    warningDiv.innerText =
        "You don't have MetaMask installed. Install MetaMask to experience the full functionality of MeowMeow!";
    warningDiv.style.display = "block";
    document.getElementById('main-content').innerHTML = "";
    // Removing the Buttons
    $('.buttons').each(function () {
        this.innerHTML = "";
    });
}

// Reload the page every time user switch an account
let account = web3.eth.accounts[0];
let accountInterval = setInterval(function () {
    if (web3.eth.accounts[0] !== account && account !== 'undefined') {
        account = web3.eth.accounts[0];
        location.reload();
    }
}, 100);

// Check if MetaMask is unlocked
function waitForAccountAndStart() {
    web3js.eth.getAccounts((err, accounts) => {
        if (!err && accounts.length > 0)
            startApp(accounts[0]);
        else
            window.setTimeout(waitForAccountAndStart, 5000);
    });
}
