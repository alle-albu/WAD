package app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import app.App;
import dao.AppointmentsRepository;
import dao.MyclassesRepository;
import dao.InstructorsRepository;


@SpringBootApplication
@EnableJpaRepositories("dao")
@EntityScan("model")

public class App {

	@Autowired
	DataSource dataSource;

	@Autowired
	InstructorsRepository instructorsRepository;
	
	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	@Autowired
	MyclassesRepository myclassesRepository;


	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

}


