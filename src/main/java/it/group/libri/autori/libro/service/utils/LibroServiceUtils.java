package it.group.libri.autori.libro.service.utils;

import it.group.libri.autori.libro.dto.LibroDTO;
import it.group.libri.autori.util.Constants;
import it.group.libri.autori.libro.dto.ResponseLibroDTO;
import java.util.List;

// Response Body builder!
public class LibroServiceUtils {
  
  public static ResponseLibroDTO buildResponseInsert(Integer idLibro) {
    ResponseLibroDTO responseLibroDTO = new ResponseLibroDTO();
        if (idLibro != null) {
          responseLibroDTO.setStatusCode(201);
          responseLibroDTO.setEsito(Constants.CREATED);
          responseLibroDTO.setIdLibro(idLibro);
          } else {
          responseLibroDTO.setStatusCode(500);
          responseLibroDTO.setEsito(Constants.NOT_CREATED);
        }
        return responseLibroDTO;
    }
  
  
  public static ResponseLibroDTO buildResponseFindById(LibroDTO libroDTO) {
    ResponseLibroDTO responseLibroDTO = new ResponseLibroDTO();
    if (libroDTO != null) {
      responseLibroDTO.setLibro(libroDTO);
      responseLibroDTO.setStatusCode(200);
      responseLibroDTO.setEsito(Constants.OK);
    } else {
      responseLibroDTO.setStatusCode(200);
      responseLibroDTO.setEsito(Constants.NOT_FOUND);
    }
    return responseLibroDTO;
  }
  
  public static ResponseLibroDTO buildresponseUpdate(Integer idLibro) {
    ResponseLibroDTO responseLibroDTO = new ResponseLibroDTO();
    if (idLibro != null) {
      responseLibroDTO.setStatusCode(200);
    } else {
      responseLibroDTO.setStatusCode(200);
      responseLibroDTO.setEsito(Constants.NOT_FOUND);
    }
    return responseLibroDTO;
  }
  
  public static ResponseLibroDTO buildResponseFilteredSearch(List<LibroDTO> libroDTOList) {
    ResponseLibroDTO responseLibroDTO = new ResponseLibroDTO();
    if (libroDTOList != null && libroDTOList.isEmpty()) {
      responseLibroDTO.setStatusCode(200);
      responseLibroDTO.setEsito(Constants.LIST_EMPTY);
      responseLibroDTO.setLibroDTOList(libroDTOList);
    } else if (libroDTOList != null) {
      responseLibroDTO.setStatusCode(200);
      responseLibroDTO.setEsito(Constants.LIST_CREATED);
      responseLibroDTO.setLibroDTOList(libroDTOList);
    } else {
      responseLibroDTO.setStatusCode(200);
      responseLibroDTO.setEsito(Constants.LIST_NOT_FOUND);
    }
    return responseLibroDTO;
  }
  
}

