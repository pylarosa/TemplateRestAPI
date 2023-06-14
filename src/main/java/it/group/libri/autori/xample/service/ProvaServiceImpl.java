package it.group.libri.autori.xample.service;

import it.group.libri.autori.util.exception.ServiceException;
import it.group.libri.autori.xample.repository.ProvaRepository;
import it.group.libri.autori.xample.service.utils.ProvaServiceUtils;
import it.group.libri.autori.xample.dto.ProvaDTO;
import it.group.libri.autori.xample.dto.ResponseProvaDTO;
import it.group.libri.autori.xample.entity.Prova;
import it.group.libri.autori.xample.mapper.ProvaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvaServiceImpl implements ProvaService {

  @Autowired
  ProvaMapper provaMapper;

  @Autowired
  ProvaRepository provaRepository;

  @Override
  public ResponseProvaDTO insertProva(ProvaDTO provaDTO) throws ServiceException {
    try {
      Prova prova = provaMapper.convertDtoToEntity(provaDTO);
      Integer idProva = provaRepository.save(prova).getIdProva();
      return ProvaServiceUtils.buildResponse(idProva);

    } catch (Exception ex) {
      throw new ServiceException("[ResponseProvaDTO].insertProva: " + ex.getMessage());
    }
  }
}
