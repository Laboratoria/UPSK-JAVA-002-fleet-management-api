package br.dev.myaki.fleetmanagementapi.repositories;

import br.dev.myaki.fleetmanagementapi.models.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
}
