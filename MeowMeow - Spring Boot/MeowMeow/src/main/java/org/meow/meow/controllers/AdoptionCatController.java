package org.meow.meow.controllers;

import org.meow.meow.models.bindingModels.AdoptionCatBindingModel;
import org.meow.meow.models.viewModels.AdoptionCatViewModel;
import org.meow.meow.repos.AdoptionCatRepository;
import org.meow.meow.services.implementations.CatContractServiceImpl;
import org.meow.meow.services.interfaces.CatContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class AdoptionCatController {
    private AdoptionCatRepository repository;
    private CatContractService service;

    public AdoptionCatController() throws Exception {
        this.repository = new AdoptionCatRepository();
        String provider = "https://ropsten.infura.io/WeEhed3KqROMFzqTsDnQ";
        System.out.println("ENTER PRIVATE KEY: ");
        Scanner scanner = new Scanner(System.in);
        String privateKey = scanner.nextLine();
        this.service = new CatContractServiceImpl(provider, privateKey);
    }

    @GetMapping("/cats/all")
    public ResponseEntity<List<AdoptionCatViewModel>> all() {
        return new ResponseEntity<>(this.repository.all(), HttpStatus.OK); // TODO
    }

    @PostMapping("/cats/add")
    public HttpStatus add(@RequestBody AdoptionCatBindingModel cat) throws Exception {
        this.service.deploy();
        this.service.add(cat);
        return HttpStatus.CREATED;
    }

    @GetMapping("/cats/profile")
    public ResponseEntity<AdoptionCatViewModel> profile(@RequestBody String name) {
        return new ResponseEntity<>(this.service.byName(name), HttpStatus.OK);
    }
}