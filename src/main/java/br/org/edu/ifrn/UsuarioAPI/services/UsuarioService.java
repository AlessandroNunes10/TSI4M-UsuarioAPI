package br.org.edu.ifrn.UsuarioAPI.services;
import br.org.edu.ifrn.UsuarioAPI.model.Usuario;
import br.org.edu.ifrn.UsuarioAPI.repository.UsuarioRepository;
import org.slf4j.Logger; import org.slf4j.LoggerFactory; import org.springframework.stereotype.Service;
import java.util.List; import java.util.Optional;
@Service
public class UsuarioService {
    private static final Logger log=LoggerFactory.getLogger(UsuarioService.class);
    private final UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository){this.repository=repository;}
    public Usuario salvar(Usuario usuario){Usuario salvo=repository.save(usuario); log.info("USUARIO_CRIADO id={} nome={} email={}",salvo.getId(),salvo.getNome(),salvo.getEmail()); return salvo;}
    public List<Usuario> listar(){List<Usuario> usuarios=repository.findAll(); log.info("USUARIO_LISTAGEM quantidade={}",usuarios.size()); return usuarios;}
    public Optional<Usuario> buscarPorId(Long id){Optional<Usuario> usuario=repository.findById(id); log.info("USUARIO_CONSULTA id={} encontrado={}",id,usuario.isPresent()); return usuario;}
    public Usuario atualizar(Long id,Usuario dados){Usuario usuario=repository.findById(id).orElseThrow(()->new RuntimeException("Usuário não encontrado.")); usuario.setNome(dados.getNome()); usuario.setEmail(dados.getEmail()); usuario.setSenha(dados.getSenha()); Usuario atualizado=repository.save(usuario); log.info("USUARIO_ATUALIZADO id={} nome={} email={}",atualizado.getId(),atualizado.getNome(),atualizado.getEmail()); return atualizado;}
    public void excluir(Long id){Usuario usuario=repository.findById(id).orElseThrow(()->new RuntimeException("Usuário não encontrado.")); repository.deleteById(id); log.info("USUARIO_EXCLUIDO id={} nome={} email={}",usuario.getId(),usuario.getNome(),usuario.getEmail());}
}