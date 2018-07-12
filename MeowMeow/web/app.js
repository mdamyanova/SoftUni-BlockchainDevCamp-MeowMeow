if (typeof web3 === 'undefined') {
    let warningDiv = document.getElementById('metamask-warning’);
    // Showing an Error
    warningDiv.innerText =
        "You don't have MetaMask installed. You can only browse but you 	won't be able to adopt pets.";
    warningDiv.style.display = "block";
    document.getElementById('mainContent').innerHTML = "";
    // Removing the Buttons
    $('.buttons').each(function () {
        this.innerHTML = "";
    });
    return;
}

let account = web3.eth.accounts[0];
let accountInterval = setInterval(function () {
    if (web3.eth.accounts[0] !== account && account !== 'undefined') {
        account = web3.eth.accounts[0];
        location.reload();
    }
}, 100);
