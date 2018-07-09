pragma solidity ^0.4.18;

contract Cat {
    enum Gender {
        Male,
        Female
    }
    struct AdoptionCat {
        bytes20 name;
        uint age;
        Gender gender;
        bytes30 town;
        string description;
        string imageHash;
        address organization;
    }
    address private owner;
    mapping (string => AdoptionCat[]) adoptionCats;
    mapping (address => uint) donations;
    constructor() public {
        owner == msg.sender;
    }
    modifier isOwner() {
        require(owner == msg.sender);
        _;
    }
    // TODO - Event for donation made?
    // TODO - Function for adoption
}