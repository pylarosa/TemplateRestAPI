package it.group.libri.autori.xample.dto;

import lombok.Data;

@Data
public class ResponseProvaDTO {
  private Integer statusCode;
  private String esito;
  private Integer idProvaCreata;
}
