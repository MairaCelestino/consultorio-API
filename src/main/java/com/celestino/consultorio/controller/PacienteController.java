package com.celestino.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celestino.consultorio.model.Paciente;
import com.celestino.consultorio.model.repository.PacienteRepository;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public PacienteController(PacienteRepository pacienteRepository) {
			this.pacienteRepository = pacienteRepository;
			pacienteRepository.getPacientes();
	}

	@GetMapping
	public ResponseEntity<List<Paciente>> listar() {
		// pacienteRepository = new PacienteRepository();
		List<Paciente> pacientes = pacienteRepository.findAll();
		if (pacientes.isEmpty()) {
			new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<>(pacientes, HttpStatus.OK);

	}

	@RequestMapping("/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Long id) {
		Paciente pacienteEncontrado = pacienteRepository.findById(id);
		if (pacienteEncontrado != null) {
			return new ResponseEntity<>(pacienteEncontrado, HttpStatus.OK);

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> deleteById(@PathVariable Long id) {
		Boolean apagado = pacienteRepository.deleteById(id);
		;
		if (apagado) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Paciente> insertPaciente(@RequestBody Paciente paciente) {
		if (paciente.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Paciente pacienteCadastrado = pacienteRepository.insertPaciente(paciente);

		return new ResponseEntity<>(pacienteCadastrado, HttpStatus.CREATED);

	}

	@PutMapping
	public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente) {
		if (paciente.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Paciente pacienteParaAtualizar = pacienteRepository.findById(paciente.getId());
		if (pacienteParaAtualizar != null) {
			pacienteParaAtualizar = pacienteRepository.updatePaciente(paciente);
			return new ResponseEntity<>(pacienteParaAtualizar, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
