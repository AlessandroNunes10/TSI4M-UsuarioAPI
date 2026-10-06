package br.org.edu.ifrn.UsuarioAPI.repository;
import br.org.edu.ifrn.UsuarioAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}