package br.com.fiap.service;

import br.com.fiap.dto.ComentarioDTO;
import br.com.fiap.model.Comentario;
import br.com.fiap.repository.ComentarioRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ComentarioService {

  private final ComentarioRepository comentarioRepository;

  public Comentario salvar(ComentarioDTO dto) {
    return comentarioRepository.save(ComentarioDTO.toComentario(dto));
  }

  public Comentario buscaComentarioPorId(Long id) {
    return comentarioRepository.findById(id).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, ("Comentário não encontrado")));
  }

  public List<Comentario> buscaTodosComentario() {
    return comentarioRepository.findAll();
  }

  public void deletaComentarioPorId(Long id) {
    var comentario = buscaComentarioPorId(id);
    comentarioRepository.delete(comentario);
  }
}
