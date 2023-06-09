package epicode.u5s2g4.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.u5s2g4.entities.Citta;

@Repository
public interface CittaRepository extends JpaRepository<Citta, UUID> {

}
