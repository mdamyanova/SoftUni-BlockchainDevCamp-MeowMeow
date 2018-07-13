pragma solidity ^0.4.24;

contract Cat {
    struct AdoptionCat {
        string name;
        uint8 age;
        string gender;
        string town;
        string descr;
        string imageHash;
        string organization;
        address catOwner;
        bool isAdopted;
    }
    
    address private owner;
    string[] private organizations; // All registered organizations
    
    mapping (string => AdoptionCat[]) adoptionCats; // Organization - Cats :))
    mapping(string => uint) indexes; // Organization name - index
    mapping (address => uint) donations;
    
    uint public allDonations;
    
    // Set Owner of Contract to be current Sender
    constructor() public {
        owner == msg.sender;
    }
    
    /**
     * Modifiers and Events
     **/
    modifier isOwner() {
        require(owner == msg.sender);
        _;
    }
    
    modifier catExists(string _organization, uint _index) {
        require(adoptionCats[_organization].length > 0);
        require(_index <= indexes[_organization]);
        _;
    }
    
    modifier canAdopt(string _organization, uint _index) {
        require(adoptionCats[_organization][_index].isAdopted == false);
        // require(_cat.catOwner != msg.sender);
        _;
    }
    
    // Event for Donation made
    event Donation(address _from, uint _amount);
    event Adopt(address _owner);
    
    /**
     * Donation
     **/
    function donate(uint _amount) public payable {
        donations[msg.sender] += _amount;
        allDonations += _amount;
        emit Donation(msg.sender, _amount);
    }
    
    function allDonations() view public returns(uint) {
        return allDonations;
    }
    
    // TODO - Transfer donations?
    
    /**
     * Get information about cats
     **/
    function info(string _organization, uint _index) 
      view public catExists(_organization, _index) 
      returns(string, uint, string, string, string, string) {
        return (adoptionCats[_organization][_index].name,
        adoptionCats[_organization][_index].age,
        adoptionCats[_organization][_index].gender,
        adoptionCats[_organization][_index].town,
        adoptionCats[_organization][_index].descr,
        adoptionCats[_organization][_index].organization);
    }
    
    function isAdopted(string _organization, uint _index) 
      view public catExists(_organization, _index)
      returns (bool) {
        return adoptionCats[_organization][_index].isAdopted;
    }
    
    function imageHash(string _organization, uint _index)
      view public catExists(_organization, _index)
      returns (string) {
          return adoptionCats[_organization][_index].imageHash;
    }
    
    function catOwner(string _organization, uint _index)
      view public catExists(_organization, _index)
      returns (address) {
          return adoptionCats[_organization][_index].catOwner;
    }
    
    /**
     * Adoption
     **/
    // Add Cat available for Adoption
    function add(string _name, uint8 _age, string _gender, string  _town,
        string _descr, string _imageHash, string _organization) public {
        AdoptionCat memory cat;
        cat.name = _name;
        cat.age = _age;
        cat.gender = _gender;
        cat.town = _town;
        cat.descr = _descr;
        cat.imageHash = _imageHash;
        cat.organization = _organization;
        cat.catOwner = msg.sender;
        cat.isAdopted = false;
        
        // Check if we have already registered organization. If not, add it.
        if (adoptionCats[_organization].length == 0) {
            organizations.push(_organization);
        }
        
        // Add current cat to adoptionCats
        if (adoptionCats[_organization].length == indexes[_organization]) {
            adoptionCats[_organization].push(cat);
            indexes[_organization] += 1; // Index and keep the organization
        } else {
            adoptionCats[_organization][indexes[_organization]] = cat;
            indexes[_organization] += 1;
        }
    }
    
    function adopt(string _organization, uint _index) 
    public catExists(_organization, _index) canAdopt(_organization, _index) {
        adoptionCats[_organization][_index].isAdopted = true;
        adoptionCats[_organization][_index].catOwner = msg.sender;
        emit Adopt(msg.sender);
    }
}