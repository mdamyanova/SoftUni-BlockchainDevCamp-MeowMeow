package org.meow.meow.services.implementations;

import org.meow.meow.models.AdoptionCat;
import org.meow.meow.models.enums.Gender;
import org.meow.meow.services.interfaces.CatContractService;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;

public class CatContractServiceImpl implements CatContractService {
    private Web3j web3;
    private Credentials credentials;
    // TODO - Contract here

    public CatContractServiceImpl(String provider, String privateKey) throws Exception {
        this.web3 = Web3j.build(new HttpService(provider));
        this.credentials = Credentials.create(privateKey);
    }

    @Override
    public void deploy() throws Exception {
        // TODO
    }

    @Override
    public void load(String address) {
        // TODO
    }

    @Override
    public void donate(int amount) {
        // TODO
    }

    @Override
    public int getAllDonations() {
        return 0; // TODO
    }

    @Override
    public AdoptionCat byName(String name) {
        return new AdoptionCat("Test", 2, Gender.Female, "Test town", "ALabala", "aaja", "aaaa"); // TODO
    }

    @Override
    public void add(AdoptionCat cat) throws Exception {
        TransactionReceipt txInfo; // TODO - Make transaction :)
        System.out.println("Transaction:\n"); // TODO - Add txInfo
    }

    @Override
    public void adopt(String name) {
        // TODO
    }
}