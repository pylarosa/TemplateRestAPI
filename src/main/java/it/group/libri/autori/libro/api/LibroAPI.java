package it.group.libri.autori.libro.api;

import it.group.libri.autori.libro.dto.LibroDTO;
import it.group.libri.autori.libro.dto.ResponseLibroDTO;
import it.group.libri.autori.libro.dto.SearchFilterLibroDTO;
import it.group.libri.autori.libro.service.LibroService;
import it.group.libri.autori.util.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibroAPI {
  
  @Autowired
  private LibroService libroService;
  
  @RequestMapping(value = "/insertLibro", method = RequestMethod.POST)
  public ResponseEntity<ResponseLibroDTO> insertLibro(@RequestBody LibroDTO libroDTO) throws ApplicationException {
    try {
      ResponseLibroDTO responseLibroDTO = libroService.insertLibro(libroDTO);
      return new ResponseEntity<>(responseLibroDTO, HttpStatus.CREATED);
      
    } catch (Exception ex) {
      throw new ApplicationException("Application Exception occurred: " + ex.getMessage());
    }
  }
  
  @RequestMapping(value = "/deleteLibro/{idLibro}", method = RequestMethod.DELETE)
  public ResponseEntity<ResponseLibroDTO> deleteLibro(@PathVariable(value = "idLibro") Integer idLibro)
          throws ApplicationException {
    try {
      libroService.deleteLibro(idLibro);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception ex) {
      throw new ApplicationException("Application Exception occurred: " + ex.getMessage());
    }
  }
  
  @RequestMapping(value = "/getLibro/{idLibro}", method = RequestMethod.GET)
  public ResponseEntity<ResponseLibroDTO> getLibro(@PathVariable(value = "idLibro") Integer idLibro)
          throws ApplicationException {
    try {
      ResponseLibroDTO responseLibroDTO = libroService.getLibroByID(idLibro);
      return ResponseEntity.ok(responseLibroDTO);
    } catch (Exception ex) {
      throw new ApplicationException("Application Exception occurred: " + ex.getMessage());
    }
  }
  
  @RequestMapping(value = "/updateLibro/{idLibro}", method = RequestMethod.PUT)
  public ResponseEntity<ResponseLibroDTO> updateLibro(
          @PathVariable(value = "idLibro") Integer idLibro,
          @RequestBody LibroDTO libroDTO)
          throws ApplicationException {
    try {
      ResponseLibroDTO responseLibroDTO = libroService.updateLibro(idLibro, libroDTO);
      return ResponseEntity.ok(responseLibroDTO);
    } catch (Exception ex) {
      throw new ApplicationException("Application Exception occurred: " + ex.getMessage());
    }
  }
  
  @RequestMapping(value = "/searchLibro", method = RequestMethod.POST)
  public ResponseEntity<ResponseLibroDTO> searchLibro(@RequestBody SearchFilterLibroDTO searchFilterLibroDTO)
          throws ApplicationException {
    try {
      ResponseLibroDTO responseLibroDTO = libroService.searchLibro(searchFilterLibroDTO);
      return ResponseEntity.ok(responseLibroDTO);
    } catch (Exception e) {
      throw new ApplicationException("Application Exception occurred");
    }
  }
}
