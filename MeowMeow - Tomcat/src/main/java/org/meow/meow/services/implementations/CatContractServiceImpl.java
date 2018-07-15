package org.meow.meow.services.implementations;

import org.meow.meow.contracts.Cat_sol_Cat;
import org.meow.meow.models.AdoptionCat;
import org.meow.meow.repos.AdoptionCatRepository;
import org.meow.meow.services.interfaces.CatContractService;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CatContractServiceImpl implements CatContractService {
    private Web3j web3;
    private Credentials credentials;
    private Cat_sol_Cat contract;
    private AdoptionCatRepository repository;

    public CatContractServiceImpl(String provider, String privateKey) throws Exception {
        this.web3 = Web3j.build(new HttpService(provider));
        this.credentials = Credentials.create(privateKey);
        this.repository = new AdoptionCatRepository();
    }

    @Override
    public void deploy() throws Exception {
        this.contract = Cat_sol_Cat
                .deploy(web3, credentials, ManagedTransaction.GAS_PRICE, BigInteger.valueOf(4600000))
                .send();
    }

    @Override
    public void load(String address) {
        this.contract = Cat_sol_Cat
                .load(address, web3, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
    }

    @Override
    public void donate(BigInteger amount) throws Exception {
        // TODO - Check if this actually works :D
        BigDecimal toWei = Convert.fromWei(amount.toString(), Convert.Unit.ETHER);
        TransactionReceipt txInfo = this.contract
                .donate(amount, toWei.toBigInteger())
                .send();
        this.printTxInfo(txInfo);
    }

    @Override
    public BigInteger getAllDonations() throws Exception {
        BigInteger allDonations = this.contract
                .allDonations().send();
        return allDonations;
    }

    @Override
    public AdoptionCat byName(String name) {
        // TODO - This is nasty
        AdoptionCat cat = this.repository.byName(name);
        // int index = this.repository.all().indexOf(cat);
        return cat;
        //RemoteCall<Tuple6<String, BigInteger, String, String, String, String>> tuple =
        //        this.contract.info(cat.getOrganization(), BigInteger.valueOf(index));

    }

    @Override
    public void add(AdoptionCat cat) throws Exception {
        TransactionReceipt txInfo = this.contract
                .add(
                        cat.getName(),
                        cat.getAge(),
                        cat.getGender(),
                        cat.getTown(),
                        cat.getDescription(),
                        cat.getImageHash(),
                        cat.getOrganization()
                )
                .send();
        this.printTxInfo(txInfo);
    }

    @Override
    public void adopt(String name) throws Exception {
        AdoptionCat cat = this.repository.byName(name);
        int index = this.repository.all().indexOf(cat);
        TransactionReceipt txInfo = this.contract
                .adopt(cat.getOrganization(), BigInteger.valueOf(index))
                .send();
        this.printTxInfo(txInfo);
    }

    private void printTxInfo(TransactionReceipt txInfo) {
        System.out.println("Transaction:\n" + txInfo);
    }
}