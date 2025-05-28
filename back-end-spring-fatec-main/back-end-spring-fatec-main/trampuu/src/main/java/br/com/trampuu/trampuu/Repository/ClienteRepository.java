package br.com.trampuu.trampuu.Repository;

import br.com.trampuu.trampuu.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNome(String nome);
}