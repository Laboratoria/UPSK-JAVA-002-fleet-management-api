package br.dev.myaki.fleetmanagementapi.controllers;

import br.dev.myaki.fleetmanagementapi.models.Taxi;
import br.dev.myaki.fleetmanagementapi.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxiController {

    @Autowired
    private TaxiRepository taxiRepository;
    @GetMapping("/taxis")
    public Page<Taxi> findAllTaxis(Pageable pageable){
        return taxiRepository.findAll(pageable);
    }
}
