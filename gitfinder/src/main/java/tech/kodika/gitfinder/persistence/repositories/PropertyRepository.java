package tech.kodika.gitfinder.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kodika.gitfinder.persistence.entities.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findByKey(String key);
}