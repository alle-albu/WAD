package dao;

import org.springframework.data.repository.CrudRepository;

import model.Myinstructor;

public interface MyinstructorsRepository extends CrudRepository<Myinstructor, Integer>{
	public Myinstructor findByLastName(String lastName);
	public Myinstructor findByFirstName(String firstName);
}
