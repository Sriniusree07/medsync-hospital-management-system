package com.hospital.controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.hospital.entity.Patient;
	import com.hospital.service.PatientService;

	@RestController
	@RequestMapping("/patients")
	public class PatientController {

	    @Autowired
	    private PatientService service;

	    @PostMapping
	    public Patient addPatient(@RequestBody Patient patient) {
	        return service.savePatient(patient);
	    }

	    @GetMapping
	    public List<Patient> getPatients() {
	        return service.getAllPatients();
	    }

	    @GetMapping("/{id}")
	    public Patient getPatient(@PathVariable Long id) {
	        return service.getPatientById(id);
	    }

	    @DeleteMapping("/{id}")
	    public String deletePatient(@PathVariable Long id) {
	        service.deletePatient(id);
	        return "Patient deleted";
	    }
	}


