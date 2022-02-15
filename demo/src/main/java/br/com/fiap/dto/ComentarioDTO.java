package br.com.fiap.dto;

import br.com.fiap.model.Comentario;
import lombok.Data;

@Data
public class ComentarioDTO {

  private String comentario;

  public static final Comentario toComentario(ComentarioDTO dto) {
    return new Comentario(dto.getComentario());
  }
}
