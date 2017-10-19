package dao;

import org.springframework.data.repository.CrudRepository;

import model.Appointment;

public interface AppointmentsRepository extends CrudRepository<Appointment, Integer>{
public Appointment findByFirstName(String fn);
public Appointment findByLastName(String ln);
public Appointment findByClassId(int ci);
}
