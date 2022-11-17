/**
 * 
 */
package com.bits.assignment.universalt10.userservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bits.assignment.universalt10.userservice.model.DoctorPatient;

/**
 * @author Vicky
 *
 */
@Repository
public interface DoctorPatientRepository extends MongoRepository<DoctorPatient, String> {

	public List<DoctorPatient> findByPatientId(String patientId);

	public List<DoctorPatient> findByDoctorId(String doctorId);

}
