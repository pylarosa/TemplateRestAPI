package it.group.libri.autori.xample.service;

import it.group.libri.autori.util.exception.ServiceException;
import it.group.libri.autori.xample.dto.ProvaDTO;
import it.group.libri.autori.xample.dto.ResponseProvaDTO;

public interface ProvaService {
  ResponseProvaDTO insertProva(ProvaDTO provaDTO) throws ServiceException;
}
