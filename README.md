# [Name here]
**[Name here]** is a fully-functional DApp (Decentralized Application) consisting of Solidity smart contract in the Ethereum blockchain + client-side app (UI) and server-side logic (todo). The [name here] keeps some data and logic in the Ethereum blockchain and provides UI to access it.

## General Requirements
- Smart contracts, implemented in Solidity, deployed in the Robsten testnet
- Client-side app - (todo - technologies here)
- Decentralized Storage - IPFS
- Unit tests - (todo - coverage)
- Server-side logic - (todo - technologies here)

## Business Logic
- *Guests* can view the *users* and their *items* listed for *selling* 
  - they don't see their contracts and addresses
- *Guests* can register as *users* and *purchase* *items* 
  - when the *item is purchased* the payment is send to the smart contract
  - the smart contract retain *5% as commision*
- *Users* register and list *items* for *sale* in the Ethereum blockchain
  - each *item* consists JSON document + image in IPFS
  - each *user* holds in a smart contract a list of IPFS hashes of the *items for sale*
- *Users* should have a wallet
  - *JS wallet or MetaMask*
  - Transaction signing is in the client-side
  
## Bonus 
- Create token
- People can use ETHs only to buy our token
- Make the token the main currency and accept only it
