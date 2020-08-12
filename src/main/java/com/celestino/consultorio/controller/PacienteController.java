package com.celestino.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celestino.consultorio.model.Paciente;
import com.celestino.consultorio.model.repository.PacienteRepository;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

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
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		Paciente pacienteDeletado = pacienteRepository.deleteById(id);
		if (pacienteDeletado != null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pacienteDeletado, HttpStatus.OK);
	}
}
