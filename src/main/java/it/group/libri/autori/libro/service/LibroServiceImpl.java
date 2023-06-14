package it.group.libri.autori.libro.service;

import it.group.libri.autori.libro.dto.LibroDTO;
import it.group.libri.autori.libro.dto.ResponseLibroDTO;
import it.group.libri.autori.libro.dto.SearchFilterLibroDTO;
import it.group.libri.autori.libro.entity.Libro;
import it.group.libri.autori.libro.repository.LibroRepository;
import it.group.libri.autori.libro.service.utils.LibroServiceUtils;
import it.group.libri.autori.util.exception.ServiceException;
import it.group.libri.autori.libro.mapper.LibroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {
  
  @Autowired
  LibroMapper libroMapper;
  
  @Autowired
  LibroRepository libroRepository;
  
  @Override
  public ResponseLibroDTO insertLibro(LibroDTO libroDTO) throws ServiceException {
    try {
      Libro libro = libroMapper.convertDtoToEntity(libroDTO);
      Integer idLibro = libroRepository.save(libro).getIdLibro();
      return LibroServiceUtils.buildResponseInsert(idLibro);
    } catch (Exception ex) {
      throw new ServiceException("[ResponseLibroDTO.insertLibro ]" + ex.getMessage());
    }
  }
  
  @Override
  public void deleteLibro(Integer idLibro) throws ServiceException {
    try {
      libroRepository.deleteById(idLibro);
    } catch (Exception ex) {
      throw new ServiceException("[ResponseLibroDTO.deleteLibro ]" + ex.getMessage());
    }
  }
  
  @Override
  public ResponseLibroDTO getLibroByID(Integer idLibro) throws ServiceException {
    try {
      Libro libro = libroRepository.getById(idLibro);
      LibroDTO libroDTO = libroMapper.convertEntityToDto(libro);
      return LibroServiceUtils.buildResponseFindById(libroDTO);
      
    } catch (Exception ex) {
      throw new ServiceException("[ResponseLibroDTO.getLibrobyID ]" + ex.getMessage());
    }
  }
  
  @Override
  public ResponseLibroDTO updateLibro(Integer idLibro, LibroDTO libroDTO) throws ServiceException{
    try {
      Libro libro = libroRepository.getById(idLibro);
      Libro libroNew = libroMapper.convertDtoToEntity(libroDTO);
      updateEntity(libro, libroNew);
      libroRepository.save(libro);
      return LibroServiceUtils.buildresponseUpdate(idLibro);
      
    } catch (Exception ex) {
      throw new ServiceException("[ResponseLibroDTO.updateLibro ]" + ex.getMessage());
    }
  }
  
  @Override
  public ResponseLibroDTO searchLibro(SearchFilterLibroDTO searchFilterLibroDTO) throws ServiceException {
    try {
      List<Libro> libroList = libroRepository.getByFilter(
              searchFilterLibroDTO.getTitolo(),
              searchFilterLibroDTO.getAutore(),
              searchFilterLibroDTO.getDataUscitaStart() != null ?
                      searchFilterLibroDTO.getDataUscitaStart().getTime() : null,
              searchFilterLibroDTO.getDataUscitaEnd() != null ?
                      searchFilterLibroDTO.getDataUscitaEnd().getTime() : null,
              searchFilterLibroDTO.getGenere() != null ? searchFilterLibroDTO.getGenere().name() : null,
              searchFilterLibroDTO.getCasaEditrice(),
              searchFilterLibroDTO.getDescrizione()
      );
      List<LibroDTO> libroDTOList = libroMapper.convertEntityToDto(libroList);
      return LibroServiceUtils.buildResponseFilteredSearch(libroDTOList);
    
    } catch (Exception e) {
      throw new ServiceException("[AutoreServiceImpl].searchLibro: " + e.getMessage());
    }
  }
  
  private static void updateEntity(Libro libro, Libro libroNew) {
    libro.setTitoloLibro(libroNew.getTitoloLibro());
    libro.setAutoreLibro(libroNew.getAutoreLibro());
    libro.setGenereLibro(libroNew.getGenereLibro());
    libro.setCasaEditrice(libroNew.getCasaEditrice());
    libro.setDescrizioneLibro(libroNew.getDescrizioneLibro());
    libro.setDataUscitaLibro(libroNew.getDataUscitaLibro());
    libro.setDataModifica(new Date());
  }
}