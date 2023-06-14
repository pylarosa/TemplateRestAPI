package it.group.libri.autori.libro.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "LIBRO")
@Entity
@Data
public class Libro implements Serializable {
  
  @Id
  @SequenceGenerator(name = "LIBRO_SEQ_GENERATOR", sequenceName = "SEQ_LIBRO", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIBRO_SEQ_GENERATOR")
  @Column(name = "ID_LIBRO", nullable = false)
  private Integer idLibro;
  
  @Column(name = "TITOLO")
  private String titoloLibro;
  
  @Column(name = "AUTORE")
  private String autoreLibro;
  
  @Column(name = "DATA_USCITA")
  private Date dataUscitaLibro;
  
  @Column(name = "GENERE")
  private String genereLibro;
  
  @Column(name = "CASA_EDITRICE")
  private String casaEditrice;
  
  @Column(name = "DESCRIZIONE")
  private String descrizioneLibro;
  
  @Column(name = "DATA_INSERIMENTO")
  private Date dataInserimento;
  
  @Column(name = "DATA_MODIFICA")
  private Date dataModifica;
  
  
  
  
}
