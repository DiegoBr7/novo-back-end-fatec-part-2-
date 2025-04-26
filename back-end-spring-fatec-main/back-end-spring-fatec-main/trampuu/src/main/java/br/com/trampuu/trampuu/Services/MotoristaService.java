package br.com.trampuu.trampuu.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trampuu.trampuu.Model.Motorista;
import br.com.trampuu.trampuu.Repository.MotoristaRepository;

@Service
public class MotoristaService {
	
	@Autowired
	private MotoristaRepository repoMotorista ;
	
	
	public Motorista gravarMotorista (Motorista a) {
		try {
			return repoMotorista.save(a);
		} catch (Exception e) {
			throw new RuntimeException("Não foi possivel enontrar o motorista");
		}
	};
	
	public List<Motorista> buscarTodosMotorista(){
		try {
			return repoMotorista.findAll();
		} catch (Exception e) {
			System.err.println("Erro ao buscar clientes: " + e.getMessage());
			   return List.of();
		}
		
	}
	
	
	
	

}
