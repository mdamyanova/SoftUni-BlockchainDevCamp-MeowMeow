package org.meow.meow.services.interfaces;

import org.meow.meow.models.bindingModels.AdoptionCatBindingModel;
import org.meow.meow.models.viewModels.AdoptionCatViewModel;

import java.math.BigInteger;

public interface CatContractService {
    void deploy() throws Exception;
    void load(String address);
    void donate(BigInteger amount) throws Exception;
    BigInteger getAllDonations() throws Exception;
    AdoptionCatViewModel byName(String name);
    void add(AdoptionCatBindingModel cat) throws Exception;
    void adopt(String name) throws Exception;
}