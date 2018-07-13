package org.meow.meow.repos;

import org.meow.meow.models.AdoptionCat;
import org.meow.meow.services.implementations.CatContractServiceImpl;
import org.meow.meow.services.interfaces.CatContractService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AdoptionCatRepository  {
    private Set<AdoptionCat> cats;

    public AdoptionCatRepository() {
        this.cats = new HashSet<>();
    }

    public Set<AdoptionCat> all() {
        return Collections.unmodifiableSet(this.cats);
    }
    public void add(AdoptionCat cat) {
        this.cats.add(cat);
    }
    public AdoptionCat byName(String name) {
        return this.cats
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}