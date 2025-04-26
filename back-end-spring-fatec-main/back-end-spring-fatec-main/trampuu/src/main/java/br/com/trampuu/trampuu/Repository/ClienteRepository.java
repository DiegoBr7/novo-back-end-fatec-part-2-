package br.com.trampuu.trampuu.Repository;

import br.com.trampuu.trampuu.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}
