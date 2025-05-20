package br.com.trampuu.trampuu.Repository;
import br.com.trampuu.trampuu.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
