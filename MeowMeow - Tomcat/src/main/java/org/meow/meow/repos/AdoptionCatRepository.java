package org.meow.meow.repos;

import org.meow.meow.models.AdoptionCat;

import java.util.*;

public class AdoptionCatRepository  {
    private List<AdoptionCat> cats;

    public AdoptionCatRepository() {
        this.cats = new ArrayList<>();
    }

    public List<AdoptionCat> all() {
        return Collections.unmodifiableList(this.cats);
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