package tech.kodika.gitfinder.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kodika.gitfinder.persistence.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}


