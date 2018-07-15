package org.meow.meow.repos;

import org.meow.meow.entities.AdoptionCat;
import org.meow.meow.models.bindingModels.AdoptionCatBindingModel;
import org.meow.meow.models.viewModels.AdoptionCatViewModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class AdoptionCatRepository  {
    private ModelMapper mapper;
    private List<AdoptionCat> cats;

    public AdoptionCatRepository() {
        this.mapper = new ModelMapper();
        this.cats = new ArrayList<>();
    }

    public List<AdoptionCatViewModel> all() {
        Type targetListType = new TypeToken<List<AdoptionCatViewModel>>() {}.getType();
        return this.mapper.map(this.cats, targetListType);
    }
    public void add(AdoptionCatBindingModel cat) {
        AdoptionCat catModel = new AdoptionCat(
                cat.getName(),
                cat.getAge(),
                cat.getGender(),
                cat.getTown(),
                cat.getDescription(),
                cat.getImageHash(),
                cat.getOrganization()
        );
        this.cats.add(catModel);
    }
    public AdoptionCat byName(String name) {
        return this.cats
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}