package dao;

import org.springframework.data.repository.CrudRepository;

import model.Myclass;

public interface MyclassesRepository extends CrudRepository<Myclass, Integer> {
	
}
