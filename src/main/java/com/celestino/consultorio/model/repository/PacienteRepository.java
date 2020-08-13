package com.celestino.consultorio.model.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.digester.SetPropertiesRule;
import org.springframework.stereotype.Service;

import com.celestino.consultorio.model.Paciente;

//está classe representa uma chamada á base de dados
@Service
public class PacienteRepository {

	private Integer nextPrimaryKey = 1;

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
			Paciente p1 = new Paciente(Long.valueOf(nextPrimaryKey.longValue()), "Maira", "mairacelestino@gmail.com",
					18);

			nextPrimaryKey++;

			// Cria objeto paciente usando os métodos setters
			Paciente p2 = new Paciente();
			p2.setId(Long.valueOf(nextPrimaryKey.longValue()));
			p2.setNome("Anderson");
			p2.setEmail("anderson@gmail.com");
			p2.setIdade(24);

			nextPrimaryKey++;

			Paciente p3 = new Paciente();
			p3.setId(Long.valueOf(nextPrimaryKey.longValue()));
			p3.setNome("Bianca");
			p3.setEmail("bianca@gmail.com");
			p3.setIdade(30);

			nextPrimaryKey++;

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

	public Boolean deleteById(Long id) {
		for (Paciente paciente : getPacientes()) {
			if (paciente.getId().equals(id)) {

				getPacientes().remove(paciente);
				return true;

			}
		}
		return false;

	}

	public Paciente insertPaciente(Paciente paciente) {
		getPacientes();
		if (paciente.getId() == null) {
			paciente.setId(Long.valueOf(nextPrimaryKey.longValue()));
			getPacientes().add(paciente);
			nextPrimaryKey++;

		}
		return paciente;
	}
//
//	public Paciente updatePaciente(Paciente paciente) {
//			
//		if (paciente.getId() != null) {
//			getPacient
//		}
//	}
}
