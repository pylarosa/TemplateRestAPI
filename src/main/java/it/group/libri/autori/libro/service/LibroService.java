package it.group.libri.autori.libro.service;

import it.group.libri.autori.libro.dto.LibroDTO;
import it.group.libri.autori.libro.dto.ResponseLibroDTO;
import it.group.libri.autori.libro.dto.SearchFilterLibroDTO;
import it.group.libri.autori.util.exception.ServiceException;

public interface LibroService {
  ResponseLibroDTO insertLibro(LibroDTO libroDTO) throws ServiceException;
  
  void deleteLibro(Integer libroDTO) throws ServiceException;
  
  ResponseLibroDTO getLibroByID(Integer idLibro) throws ServiceException;
  
  ResponseLibroDTO updateLibro(Integer idLibro, LibroDTO libroDTO) throws ServiceException;
  
  ResponseLibroDTO searchLibro(SearchFilterLibroDTO searchFilterLibroDTO) throws ServiceException;
}
