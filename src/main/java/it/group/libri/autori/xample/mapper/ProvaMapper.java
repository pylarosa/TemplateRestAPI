package it.group.libri.autori.xample.mapper;

import it.group.libri.autori.util.MapperComponent;
import it.group.libri.autori.util.exception.MapperException;
import it.group.libri.autori.xample.dto.ProvaDTO;
import it.group.libri.autori.xample.entity.Prova;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component
public class ProvaMapper implements MapperComponent<ProvaDTO, Prova> {
  @Override
  public ProvaDTO convertEntityToDto(Prova entity) throws MapperException {
    return null;
  }

  @Override
  public Prova convertDtoToEntity(ProvaDTO dto) throws MapperException {
    try {
      if (dto != null) {
        Prova prova = new Prova();
        prova.setNomeProva(dto.getNomeProva());
        prova.setAutoreProva(dto.getAutoreProva());

        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateAsString = dto.getDataProva();
        Date date = sourceFormat.parse(dateAsString);

        prova.setDataProva(date);
        return prova;
      }

      return null;
    } catch (Exception ex) {
      throw new MapperException("[ProvaMapper].convertDtoToEntity: " + ex.getMessage());
    }
  }

  @Override
  public List<ProvaDTO> convertEntityToDto(List<Prova> entityList) throws MapperException {
    return null;
  }

  @Override
  public List<Prova> convertDtoToEntity(List<ProvaDTO> dtoList) throws MapperException {
    return null;
  }
}
