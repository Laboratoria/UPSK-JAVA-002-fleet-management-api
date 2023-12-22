package br.dev.myaki.fleetmanagementapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxiController {

    @GetMapping("/taxis")
    public String get(){
       return "Hola, Laboratorian";
    }
}
