const Cat = artifacts.require('./contracts/Cat.sol');
contract('Cat', function (accounts) {
    const _owner = accounts[0];
    const _notOwner = accounts[1];

    // TODO
    // Main initialization
    it("The contract should start have 0 donations.", async function () {
        let cat = await Cat.new();
        let expectedDonations = 0;
        let allDonations = await cat.allDonations();
        assert.strictEqual(expectedDonations.toNumber, allDonations, "The number of donations is not 0.");
    });
    it("Should register donation from address.", async function () {
        let address = "0x52b7014aCDa7d2ae09683D4d9fc0a3376bb95001";
        let amount = 1;
        let donation = await contract.donate(amount);
        let all = await contract.allDonations;
        assert.strictEqual(1, all);
    })
});