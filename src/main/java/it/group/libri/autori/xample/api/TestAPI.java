package it.group.libri.autori.xample.api;

import it.group.libri.autori.util.exception.ApplicationException;
import it.group.libri.autori.xample.dto.AddendiDTO;
import it.group.libri.autori.xample.dto.ProvaDTO;
import it.group.libri.autori.xample.dto.ResponseProvaDTO;
import it.group.libri.autori.xample.service.ProvaService;
import it.group.libri.autori.xample.service.SommaService;
import it.group.libri.autori.xample.dto.SommaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestAPI {

  @Autowired
  private SommaService service;

  @Autowired
  private ProvaService provaService;

  @RequestMapping(value = "/sommaAddendi", method = RequestMethod.POST)
  public ResponseEntity<SommaDTO> sommaAddendi(@RequestBody AddendiDTO addendi) throws ApplicationException {
    try {
      SommaDTO sommaDTO = service.sommaAddendi(addendi);
      return ResponseEntity.ok(sommaDTO);

    } catch (Exception ex) {
      throw new ApplicationException("Application Exception occurred");
    }
  }

  @RequestMapping(value = "/insertProva", method = RequestMethod.POST)
  public ResponseEntity<ResponseProvaDTO> insertProva(@RequestBody ProvaDTO provaDTO) throws ApplicationException {
    try {
      ResponseProvaDTO responseProvaDTO = provaService.insertProva(provaDTO);
      return new ResponseEntity<>(responseProvaDTO, HttpStatus.CREATED);

    } catch (Exception ex) {
      throw new ApplicationException("Application Exception occurred");
    }
  }

}
