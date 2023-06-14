package it.group.libri.autori.xample.service.utils;

import it.group.libri.autori.util.Constants;
import it.group.libri.autori.xample.dto.ResponseProvaDTO;

public class ProvaServiceUtils {

  public static ResponseProvaDTO buildResponse(Integer idProva) {
    ResponseProvaDTO responseProvaDTO = new ResponseProvaDTO();
    if (idProva != null) {
      responseProvaDTO.setStatusCode(201);
      responseProvaDTO.setEsito(Constants.CREATED);
      responseProvaDTO.setIdProvaCreata(idProva);
    } else {
      responseProvaDTO.setStatusCode(500);
      responseProvaDTO.setEsito(Constants.NOT_CREATED);
    }
    return responseProvaDTO;
  }
}
