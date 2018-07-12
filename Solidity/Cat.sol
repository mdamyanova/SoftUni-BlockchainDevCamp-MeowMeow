pragma solidity ^0.4.18;

contract Cat {
    enum Gender {
        Male,
        Female
    }
    struct AdoptionCat {
        string name;
        uint8 age;
        Gender gender;
        string town;
        string descr;
        string imageHash;
        string organization;
        address catOwner;
        bool isAdopted;
    }
    
    address private owner;
    string[] private organizations; // All registered organizations
    mapping (string => AdoptionCat[]) adoptionCats; // All cats by organization
    mapping (address => uint) donations;
    uint public allDonations;
    
    // Set Owner of Contract to be current Sender
    constructor() public {
        owner == msg.sender;
    }
    
    // The Owner must be the User
    modifier isOwner() {
        require(owner == msg.sender);
        _;
    }
    
    // Event for Donation made
    event Donation(address _from, uint _amount);
    
    /**
     * Donation
     **/
    
    function donate(uint _amount) public payable {
        donations[msg.sender] += _amount;
        allDonations += _amount;
        emit Donation(msg.sender, _amount);
    }
    
    function getAllDonations() view public returns(uint) {
        return allDonations;
    }
    
    // TODO - Transfer donations?
    
    /**
     * Adoption
     **/
    
    // TODO - Cat exists?
    
    function info(string name) view public returns(string _name, uint8 _age, 
        Gender _gender, string  _town, string _descr, string _imageHash,
        string organization, string catOwner, bool isAdopted) {
            // Check if we have this cat
            if (adoptionCats[organization][name].length == 0) {
                throw;
            }
            
            // TODO - Return as Cat object
            return (
                adoptionCats[organization][name].name,
                adoptionCats[organization][name].age,
                adoptionCats[organization][name].gender,
                adoptionCats[organization][name].town,
                adoptionCats[organization][name].descr,
                adoptionCats[organization][name].imageHash,
                adoptionCats[organization][name].organization,
                adoptionCats[organization][name].catOwner,
                adoptionCats[organization][name].isAdopted
                );
    }
        
    // Add Cat available for Adoption
    function add(string _name, uint8 _age, Gender _gender, string  _town, 
        string _descr, string _imageHash) {
        AdoptionCat memory cat;
        cat.name = _name;
        cat.age = _age;
        cat.gender = _gender;
        cat.town = _town;
        cat.descr = _descr;
        cat.imageHash = _imageHash;
        cat.organization = "ICat Rescue"; // TODO
        cat.catOwner = msg.sender;
        cat.isAdopted = false;
        
        // Check if we have already registered organization. If not, add it.
        // TODO
        if (adoptionCats[cat.organization].length == 0) {
            organizations.push(cat.organization);
        } 
        
        // Add current cat to adoptionCats
        if (adoptionCats[cat.name].length == 0) {
            adoptionCats[cat.name].push(cat);
        }
    }
    
    function adopt(string name) {
        // TODO - Find cat and set isAdopted = true; :))
        
    }
}