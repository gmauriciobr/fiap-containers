package br.com.fiap.controller;

import br.com.fiap.dto.ComentarioDTO;
import br.com.fiap.service.ComentarioService;
import br.com.fiap.viewmodel.ComentarioViewModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/comentario")
@RequiredArgsConstructor
@Tag(name = "comentario", description = "Serviço para administração de comentario")
public class ComentarioController {

  private final ComentarioService comentarioService;

  @PostMapping
  @Operation(summary = "Cadastra comentario", tags = {"comentario"})
  public ResponseEntity<ComentarioViewModel> salvarComentario(@RequestBody ComentarioDTO dto, UriComponentsBuilder uriBuilder) {
    var comentario = comentarioService.salvar(dto);
    var uri = uriBuilder.path("/comentario/{id}").buildAndExpand(comentario.getId()).toUri();
    return ResponseEntity.created(uri).body(new ComentarioViewModel(comentario));
  }

  @GetMapping
  @Operation(summary = "Busca todos comentario", tags = {"comentario"})
  public ResponseEntity<List<ComentarioViewModel>> buscaTodosComentario() {
    return ResponseEntity.ok(ComentarioViewModel.parse(comentarioService.buscaTodosComentario()));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Busca comentario por id", tags = {"comentario"})
  public ResponseEntity<ComentarioViewModel> buscaComentarioPorId(@PathVariable Long id) {
    return ResponseEntity.ok(new ComentarioViewModel(comentarioService.buscaComentarioPorId(id)));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Deleta comentario por id", tags = {"comentario"})
  public ResponseEntity<Void> deletaComentarioPorId(@PathVariable Long id) {
     comentarioService.deletaComentarioPorId(id);
     return ResponseEntity.ok().build();
  }

}
