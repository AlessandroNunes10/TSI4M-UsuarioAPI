package br.org.edu.ifrn.UsuarioAPI.controllers;
import br.org.edu.ifrn.UsuarioAPI.model.Usuario;
import br.org.edu.ifrn.UsuarioAPI.services.UsuarioService;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service){this.service=service;}
    @PostMapping public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){return ResponseEntity.ok(service.salvar(usuario));}
    @GetMapping public ResponseEntity<List<Usuario>> listar(){return ResponseEntity.ok(service.listar());}
    @GetMapping("/{id}") public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
    @PutMapping("/{id}") public ResponseEntity<Usuario> atualizar(@PathVariable Long id,@RequestBody Usuario usuario){return ResponseEntity.ok(service.atualizar(id,usuario));}
    @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){service.excluir(id);return ResponseEntity.noContent().build();}
}