package org.meow.meow.services.interfaces;

import org.meow.meow.models.AdoptionCat;

import java.math.BigInteger;

public interface CatContractService {
    void deploy() throws Exception;
    void load(String address);
    void donate(BigInteger amount) throws Exception;
    BigInteger getAllDonations() throws Exception;
    AdoptionCat byName(String name);
    void add(AdoptionCat cat) throws Exception;
    void adopt(String name) throws Exception;
}