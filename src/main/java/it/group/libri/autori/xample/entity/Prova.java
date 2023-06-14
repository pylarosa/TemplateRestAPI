package it.group.libri.autori.xample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name = "PROVA")
@Entity
@Data
public class Prova implements Serializable {

  @Id
  @SequenceGenerator(name = "PROVA_SEQ_GENERATOR", sequenceName = "SEQ_PROVA", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVA_SEQ_GENERATOR")
  @Column(name = "ID_PROVA", nullable = false)
  private Integer idProva;

  @Column(name = "NOME_PROVA")
  private String nomeProva;

  @Column(name = "AUTORE_PROVA")
  private String autoreProva;

  @Column(name = "DATA_PROVA")
  private Date dataProva;
}
