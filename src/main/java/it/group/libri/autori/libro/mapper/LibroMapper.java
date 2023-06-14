package it.group.libri.autori.libro.mapper;

import it.group.libri.autori.libro.dto.LibroDTO;
import it.group.libri.autori.libro.dto.enums.Genere;
import it.group.libri.autori.libro.entity.Libro;
import it.group.libri.autori.util.exception.MapperException;
import it.group.libri.autori.util.MapperComponent;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class LibroMapper implements MapperComponent<LibroDTO, Libro> {
  @Override
  public LibroDTO convertEntityToDto(Libro entity) throws MapperException {
    try {
      if (entity != null) {
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setTitoloLibro(entity.getTitoloLibro().strip());
        libroDTO.setAutoreLibro(entity.getAutoreLibro().strip());
        // DateCalendar
        Calendar calendarUscitaLibro = Calendar.getInstance();
        calendarUscitaLibro.setTime(entity.getDataUscitaLibro());
        libroDTO.setDataUscitaLibro(calendarUscitaLibro);
        
        libroDTO.setGenereLibro(Genere.valueOf(entity.getGenereLibro().strip()));  // MAP ENUMS
        libroDTO.setCasaEditrice(entity.getCasaEditrice().strip());
        libroDTO.setDescrizioneLibro(entity.getDescrizioneLibro().strip());
  
        Calendar calendarDataInserimento = Calendar.getInstance();
        calendarDataInserimento.setTime(entity.getDataInserimento());
        libroDTO.setDataInserimento(calendarDataInserimento);
        
//        Calendar calendarDataModifica = Calendar.getInstance();
//        calendarDataModifica.setTime(entity.getDataModifica());
        libroDTO.setDataModifica(null);

        libroDTO.setIdLibro(entity.getIdLibro());
        
        return libroDTO;
      }
    } catch (Exception ex) {
      throw new MapperException("[LibroMapper].convertEntityToDTO: " + ex.getMessage());
    }
    return null;
  }
  
  @Override
  public Libro convertDtoToEntity(LibroDTO dto) throws MapperException {
    try {
      if (dto != null) {
        Libro libro = new Libro();
        libro.setTitoloLibro(dto.getTitoloLibro());
        libro.setAutoreLibro(dto.getAutoreLibro());
        libro.setDataUscitaLibro(dto.getDataUscitaLibro().getTime());
        libro.setGenereLibro(dto.getGenereLibro().name().strip());            // MAP ENUMS -
                                                  // .strip() is needed since the db saves ends some values with spaces!
        libro.setCasaEditrice(dto.getCasaEditrice().strip());
        libro.setDescrizioneLibro(dto.getDescrizioneLibro().strip());
        libro.setDataInserimento(new Date());
        return libro;
      }
      
    } catch (Exception ex) {
      throw new MapperException("[LibroMapper].convertDtoToEntity: " + ex.getMessage());
    }
    return null;
  }
  
  @Override
  public List<LibroDTO> convertEntityToDto(List<Libro> entityList) throws MapperException {
    try {
      if (entityList != null) {
        List<LibroDTO> libroDTOList = new ArrayList<>();
        for (Libro libro : entityList) {
          libroDTOList.add(convertEntityToDto(libro));
        }
        return libroDTOList;
      }
      return null;
    
    } catch (Exception e) {
      throw new MapperException("[AutoreMapper].convertEntityToDto: " + e.getMessage());
    }
  }
  
  @Override
  public List<Libro> convertDtoToEntity(List<LibroDTO> dtoList) throws MapperException {
    return null;
  }
}
