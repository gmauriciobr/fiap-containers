package br.com.fiap.viewmodel;

import br.com.fiap.model.Comentario;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ComentarioViewModel {

  private Long id;
  private String comentario;

  public ComentarioViewModel(Comentario comentario) {
    BeanUtils.copyProperties(comentario, this);
  }

  public static List<ComentarioViewModel> parse(List<Comentario> list) {
    return list.stream().map(ComentarioViewModel::new).collect(Collectors.toList());
  }
}
