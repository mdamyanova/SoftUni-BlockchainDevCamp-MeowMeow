pragma solidity ^0.4.21;

import "truffle/Assert.sol";
import "../contracts/Cat.sol";

contract CatTest {
    function testSettingAnOwnerDuringCreation() public {
        Cat cat = new Cat();
        Assert.equal(cat.owner(), this, "An owner is different than a deployer.");
    }
}