package tech.kodika.gitfinder.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kodika.gitfinder.persistence.entities.BuiltBy;

public interface BuiltByRepository extends JpaRepository<BuiltBy, Long> {
    BuiltBy findByUsername(String username);
}


