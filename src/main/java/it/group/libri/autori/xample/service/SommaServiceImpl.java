package it.group.libri.autori.xample.service;

import it.group.libri.autori.xample.dto.AddendiDTO;
import it.group.libri.autori.xample.dto.SommaDTO;
import org.springframework.stereotype.Service;

@Service
public class SommaServiceImpl implements SommaService {

  @Override
  public SommaDTO sommaAddendi(AddendiDTO addendi) {
    SommaDTO sommaDTO = new SommaDTO();
    sommaDTO.setSomma(addendi.getAdd1() + addendi.getAdd2());

    return sommaDTO;
  }
}
