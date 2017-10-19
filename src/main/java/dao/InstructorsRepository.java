package dao;

import org.springframework.data.repository.CrudRepository;

import model.Instructor;

public interface InstructorsRepository extends CrudRepository<Instructor, Integer>{
	public Instructor findByLastName(String lastName);
	public Instructor findByFirstName(String firstName);
}