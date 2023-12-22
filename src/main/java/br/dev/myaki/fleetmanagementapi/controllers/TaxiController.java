package br.dev.myaki.fleetmanagementapi.controllers;

import br.dev.myaki.fleetmanagementapi.models.Taxi;
import br.dev.myaki.fleetmanagementapi.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaxiController {

    @Autowired
    private TaxiRepository taxiRepository;
    @GetMapping("/taxis")
    public List<Taxi> get(){

        return taxiRepository.findAll();
    }
}
