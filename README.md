# MeowMeow
**MeowMeow** is a fully-functional DApp (Decentralized Application) consisting of Solidity smart contract in the Ethereum blockchain + client-side app (UI with ReactJS) and server-side logic (Java). The MeowMeow keeps some data and logic in the Ethereum blockchain and provides UI to access it.

## General Requirements
- Smart contracts, implemented in Solidity, deployed in the Robsten testnet
- Client-side app - (todo - technologies here)
- Decentralized Storage - IPFS
- Unit tests - (todo - coverage)
- Server-side logic - (todo - technologies here)

## Business Logic
- *Guests* can view the *organizations* and their *cats* listed for *adoption* 
  - They don't see their contracts and addresses
- *Guests* can register as *users* and *adopt cats*
  - When the *cat is adopted* the payment is send to the smart contract
  - The smart contract retain *5% as commision*
- *Organizations* register and list *cats* for *adoption* in the Ethereum blockchain
  - Each *cat* consists JSON document + image in IPFS
  - Each *organization* holds in a smart contract a list of IPFS hashes of the *cats for adoption*
- *Organizations* should have Ethereum address, don't need to have a wallet
- *Users* should have a wallet
  - *JS wallet or MetaMask*
  - Transaction signing is in the client-side
  
## Bonus 
- Create token
- People can use ETHs only to buy our token
- Make the token the main currency and accept only it
