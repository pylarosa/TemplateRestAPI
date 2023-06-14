package it.group.libri.autori.libro.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseLibroDTO {
    private Integer statusCode;
    private String esito;
    private Integer idLibro;
    private LibroDTO libro;
    private List<LibroDTO> libroDTOList;
  }

