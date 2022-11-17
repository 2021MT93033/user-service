/**
 * 
 */
package com.bits.assignment.universalt10.userservice.controller;

import java.util.List;

import org.apache.logging.log4j.message.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.assignment.universalt10.userservice.model.DoctorPatient;
import com.bits.assignment.universalt10.userservice.service.DoctorPatientService;

/**
 * @author Vicky
 *
 */
@RestController
public class DoctorPatientController {

	@Autowired
	private DoctorPatientService service;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/health")
	public ResponseEntity<?> getHealthOfTheService() {
		return ResponseEntity.ok(new SimpleMessage("The Service is Functioning"));
	}

	// GET EndPoints

	@GetMapping("/doctorpatient")
	public ResponseEntity<List<DoctorPatient>> getAllDoctorPaitentRecords() throws Exception {

		return ResponseEntity.ok(service.getAllDoctorPatient());

	}

	@GetMapping("/doctorpatient/doctor/{doctorId}")
	public ResponseEntity<List<DoctorPatient>> getAllDoctorPaitentRecordsByDoctorId(@PathVariable String doctorId)
			throws Exception {

		return ResponseEntity.ok(service.getDoctorPatientByDoctorId(doctorId));

	}

	@GetMapping("/doctorpatient/patient/{patientId}")
	public ResponseEntity<List<DoctorPatient>> getAllDoctorPaitentRecordsByHospitalName(@PathVariable String patientId)
			throws Exception {

		return ResponseEntity.ok(service.getDoctorPatientBypatientId(patientId));

	}

	@GetMapping("/doctorpatient/{id}")
	public ResponseEntity<DoctorPatient> getDoctorPaitentRecordsByReportId(@PathVariable String id) throws Exception {

		return ResponseEntity.ok(service.getDoctorPatientById(id));

	}

	// POST

	@PostMapping("/doctorpatient")
	public ResponseEntity<DoctorPatient> createDoctorPatient(@RequestBody DoctorPatient doctorPatient)
			throws Exception {
		return ResponseEntity.ok(service.createDoctorPatient(doctorPatient));
	}

	// PUT

	@PutMapping("/doctorpatient/{id}")
	public ResponseEntity<DoctorPatient> updateDoctorPatient(@RequestBody DoctorPatient doctorPatient,
			@PathVariable String id) throws Exception {
		return ResponseEntity.ok(service.updateDoctorPatient(id, doctorPatient));
	}

	// DELETE

	@DeleteMapping("/doctorpatient/{id}")
	public ResponseEntity<?> deleteDoctorPatient(@PathVariable String id) throws Exception {
		service.deleteDoctorpatient(id);
		return ResponseEntity.noContent().build();
	}

}
