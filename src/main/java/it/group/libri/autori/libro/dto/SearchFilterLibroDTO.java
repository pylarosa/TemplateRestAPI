package it.group.libri.autori.libro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.group.libri.autori.libro.dto.enums.Genere;
import lombok.Data;
import java.util.Calendar;

@Data
public class SearchFilterLibroDTO {
  private String titolo;
  private String autore;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "CET")
  private Calendar dataUscitaStart;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "CET")
  private Calendar dataUscitaEnd;
  private Genere genere;
  private String casaEditrice;
  private String descrizione;
}
