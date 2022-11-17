/**
 * 
 */
package com.bits.assignment.universalt10.userservice.service;

import java.util.List;

import com.bits.assignment.universalt10.userservice.model.DoctorPatient;

/**
 * @author Vicky
 *
 */
public interface DoctorPatientService {

	public List<DoctorPatient> getAllDoctorPatient() throws Exception;

	public DoctorPatient getDoctorPatientById(String id) throws Exception;

	public List<DoctorPatient> getDoctorPatientByDoctorId(String doctorId) throws Exception;

	public List<DoctorPatient> getDoctorPatientBypatientId(String patientId) throws Exception;

	public DoctorPatient createDoctorPatient(DoctorPatient doctorPatient) throws Exception;

	public DoctorPatient updateDoctorPatient(String id, DoctorPatient doctorPatient) throws Exception;

	public void deleteDoctorpatient(String id) throws Exception;

}
