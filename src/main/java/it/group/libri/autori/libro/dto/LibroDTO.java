package it.group.libri.autori.libro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.group.libri.autori.libro.dto.enums.Genere;
import lombok.Data;

import java.util.Calendar;

@Data
public class LibroDTO {
  private Integer idLibro;
  private String titoloLibro;
  private String autoreLibro;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="CET")
  private Calendar dataUscitaLibro;
  private Genere genereLibro;
  private String casaEditrice;
  private String descrizioneLibro;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="CET")
  private Calendar dataInserimento;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="CET")
  private Calendar dataModifica;
  
}
