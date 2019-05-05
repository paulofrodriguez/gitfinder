package tech.kodika.gitfinder.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kodika.gitfinder.persistence.entities.License;

public interface LicenseRepository extends JpaRepository<License, Long> {

}


