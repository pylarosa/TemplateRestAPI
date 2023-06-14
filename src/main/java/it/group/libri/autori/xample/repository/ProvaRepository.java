package it.group.libri.autori.xample.repository;

import it.group.libri.autori.xample.entity.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Integer> {

}
