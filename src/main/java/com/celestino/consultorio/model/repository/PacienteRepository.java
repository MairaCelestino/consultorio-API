package com.celestino.consultorio.model.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.celestino.consultorio.model.Paciente;

//está classe representa uma chamada á base de dados
@Service
public class PacienteRepository {

	// Lista de pacientes para retornar
	private List<Paciente> pacientes;

	// Método que retorna listagem de pacientes
	public List<Paciente> findAll() {

		return getPacientes();
	}

	// Retorna lista inicializada caso necessário
	public List<Paciente> getPacientes() {
		if (pacientes == null) {
			pacientes = new ArrayList<Paciente>();

			// Cria paciente usando contrutor
			Paciente p1 = new Paciente(1L, "Maira", "mairacelestino@gmail.com", 18);

			// Cria objeto paciente usando os métodos setters
			Paciente p2 = new Paciente();
			p2.setId(2L);
			p2.setNome("Anderson");
			p2.setEmail("anderson@gmail.com");
			p2.setIdade(24);

			Paciente p3 = new Paciente();
			p3.setId(3L);
			p3.setNome("Bianca");
			p3.setEmail("bianca@gmail.com");
			p3.setIdade(30);

			// Insere na lista
			getPacientes().add(p1);
			getPacientes().add(p2);
			getPacientes().add(p3);

			// Outra forma de popular uma lista
			// return Arrays.asList(p1, p2, p3);
		}
		return pacientes;
	}

	// Buscar paciente pelo id
	public Paciente findById(Long id) {
		for (Paciente paciente : getPacientes()) {
			if (paciente.getId().equals(id)) {
				return paciente;
			}
		}
		return null;
	}

}
