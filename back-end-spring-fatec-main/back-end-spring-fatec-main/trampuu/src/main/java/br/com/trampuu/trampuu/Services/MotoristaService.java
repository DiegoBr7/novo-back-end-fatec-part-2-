package br.com.trampuu.trampuu.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.trampuu.trampuu.Model.Motorista;
import br.com.trampuu.trampuu.Repository.MotoristaRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MotoristaService {

	@Autowired
	private MotoristaRepository repoMotorista;


	public Motorista gravarMotorista(Motorista a) {
		try {
			return repoMotorista.save(a);
		} catch (Exception e) {
			e.printStackTrace(); // Adicione isso para ver o erro real
			throw new RuntimeException("Erro ao gravar motorista: " + e.getMessage());
		}
	}


	public List<Motorista> buscarTodosMotorista() {
		try {
			return repoMotorista.findAll();
		} catch (Exception e) {
			System.err.println("Erro ao buscar clientes: " + e.getMessage());
			return List.of();
		}

	}

	public Motorista atualizarMotorista(Motorista m, Long id) {
		Optional<Motorista> motorista = repoMotorista.findById(id);
		if (motorista.isPresent()) {
			m.setId_Motorista(Math.toIntExact(id));
			return repoMotorista.save(m);
		} else throw new RuntimeException("Nao encontrado");
	}

	public void excluirPorId(
			Long id
	){
		Motorista motorista = repoMotorista.findById(id)
				.orElseThrow(() ->
						new ResponseStatusException(
								HttpStatus.NOT_FOUND,
								"Motorista nao encontrado :" + id
						));
		 repoMotorista.delete(motorista);

	}
}

