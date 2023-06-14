package it.group.libri.autori.libro.repository;

import it.group.libri.autori.libro.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
  @Query("SELECT l " +
          "FROM Libro l " +
          "WHERE " +
          "    (:titolo IS NULL OR UPPER(l.titoloLibro) LIKE '%' || UPPER(:titolo) || '%') AND " +
          "    (:autore IS NULL OR l.autoreLibro = :autore) AND " +
          "    (:dataUscitaStart IS NULL OR l.dataUscitaLibro >= :dataUscitaStart) AND " +
          "    (:dataUscitaEnd IS NULL OR l.dataUscitaLibro <= :dataUscitaEnd) AND " +
          "    (:genere IS NULL OR UPPER(l.genereLibro) LIKE '%' || UPPER(:genere) || '%') AND " +
          "    (:casaEditrice IS NULL OR UPPER(l.casaEditrice) LIKE '%' || UPPER(:casaEditrice) || '%') AND " +
          "    (:descrizione IS NULL OR UPPER(l.descrizioneLibro) LIKE '%' || UPPER(:descrizione) || '%') ")
  List<Libro> getByFilter(
          @Param("titolo") String titolo,
          @Param("autore") String autore,
          @Param("dataUscitaStart") Date dataUscitaStart,
          @Param("dataUscitaEnd") Date dataUscitaEnd,
          @Param("genere") String genere,
          @Param("casaEditrice") String casaEditrice,
          @Param("descrizione") String descrizione
  );
  
  // List<Libro> findAllByOrderByTitoloLibroAsc();  -> To_Do
}
