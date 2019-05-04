package tech.kodika.gitfinder.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kodika.gitfinder.persistence.entities.Repo;

public interface RepoRepository extends JpaRepository<Repo, Long> {
    Repo findByName(String name);
}
