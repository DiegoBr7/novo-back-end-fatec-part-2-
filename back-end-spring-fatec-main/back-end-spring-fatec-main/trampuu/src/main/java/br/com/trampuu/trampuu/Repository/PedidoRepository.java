package br.com.trampuu.trampuu.Repository;

import br.com.trampuu.trampuu.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
