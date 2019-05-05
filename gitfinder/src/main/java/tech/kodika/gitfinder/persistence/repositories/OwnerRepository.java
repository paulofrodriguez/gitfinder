package tech.kodika.gitfinder.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kodika.gitfinder.persistence.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}


