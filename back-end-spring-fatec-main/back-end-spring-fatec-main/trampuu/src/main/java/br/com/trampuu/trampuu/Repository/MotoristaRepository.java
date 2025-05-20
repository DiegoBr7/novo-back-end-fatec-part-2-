package br.com.trampuu.trampuu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trampuu.trampuu.Model.Motorista;

import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

}
