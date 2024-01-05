package br.dev.myaki.fleetmanagementapi.controllers;

import br.dev.myaki.fleetmanagementapi.models.Taxi;
import br.dev.myaki.fleetmanagementapi.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxiController {

    @Autowired
    private TaxiRepository taxiRepository;
    @GetMapping("/taxis")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Page<Taxi> findAllTaxis(Pageable pageable){
        return taxiRepository.findAll(pageable);
    }
}
