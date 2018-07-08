package com.meowmeow;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class ContractService {
    private Web3j web3j;
    private Credentials credentials;
    private MeowToken_sol_MeowToken contract;

    public ContractService(String provider, String privateKey) throws Exception {
        this.web3j = Web3j.build(new HttpService(provider));
        this.credentials = Credentials.create(privateKey);
    }
}