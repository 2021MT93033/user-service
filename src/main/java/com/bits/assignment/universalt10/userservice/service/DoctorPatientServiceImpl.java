/**
 * 
 */
package com.bits.assignment.universalt10.userservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.assignment.universalt10.userservice.model.DoctorPatient;
import com.bits.assignment.universalt10.userservice.repository.DoctorPatientRepository;

/**
 * @author Vicky
 *
 */
@Service
public class DoctorPatientServiceImpl implements DoctorPatientService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DoctorPatientRepository repo;

	@Override
	public List<DoctorPatient> getAllDoctorPatient() throws Exception {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public DoctorPatient getDoctorPatientById(String id) throws Exception {
		// TODO Auto-generated method stub
		Optional<DoctorPatient> opt = repo.findById(id);
		return opt.orElse(null);
	}

	@Override
	public List<DoctorPatient> getDoctorPatientByDoctorId(String doctorId) throws Exception {
		// TODO Auto-generated method stub
		return repo.findByDoctorId(doctorId);
	}

	@Override
	public List<DoctorPatient> getDoctorPatientBypatientId(String patientId) throws Exception {
		// TODO Auto-generated method stub
		return repo.findByPatientId(patientId);
	}

	@Override
	public DoctorPatient createDoctorPatient(DoctorPatient doctorPatient) throws Exception {
		// TODO Auto-generated method stub
		return repo.save(doctorPatient);
	}

	@Override
	public DoctorPatient updateDoctorPatient(String id, DoctorPatient doctorPatient) throws Exception {
		if (!id.equals(doctorPatient.getId())) {
			throw new Exception("Illegal Request Exception, The id in the url and request is not matching");
		}

		DoctorPatient existingReport = getDoctorPatientById(doctorPatient.getId());

		if (existingReport == null) {
			throw new Exception("unable to find the record to update");
		}
		return repo.save(doctorPatient);
	}

	@Override
	public void deleteDoctorpatient(String id) throws Exception {
		DoctorPatient existingReport = getDoctorPatientById(id);

		if (existingReport == null) {
			throw new Exception("unable to find the record to delete");
		}

		repo.delete(existingReport);

	}

}
