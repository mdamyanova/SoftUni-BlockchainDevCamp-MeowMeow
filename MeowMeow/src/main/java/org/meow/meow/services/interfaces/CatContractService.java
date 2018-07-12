package org.meow.meow.services.interfaces;

import org.meow.meow.models.AdoptionCat;

public interface CatContractService {
    void deploy() throws Exception;
    void load(String address);
    void donate(int amount);
    int getAllDonations(); // int is too small ?
    AdoptionCat byName(String name);
    void add(AdoptionCat cat) throws Exception;
    void adopt(String name);
}