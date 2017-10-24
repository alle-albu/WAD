package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;

import dao.AppointmentsRepository;
import dao.InstructorsRepository;
import dao.MyclassesRepository;
import model.Appointment;
import model.Instructor;
import model.Myclass;

@RestController
@CrossOrigin(maxAge = 3600)
public class WebController {

	@Autowired
	InstructorsRepository instructorsRepository;
	
	@Autowired
	MyclassesRepository myclassesRepository;

	@Autowired
	AppointmentsRepository appointmentsRepository;

	@RequestMapping(value = "/instructors", method = RequestMethod.GET)
	String getInstructors() {
		JsonArray instructorsArray = new JsonArray();
		for (Instructor i : instructorsRepository.findAll()) {
			instructorsArray.add(i.toJsonObject());
		}
		return instructorsArray.toString();
	}
	
	@RequestMapping(value = "/myclasses", method = RequestMethod.GET)
	String getMyclasses() {
		JsonArray classesArray = new JsonArray();
		for (Myclass c : myclassesRepository.findAll()) {
			classesArray.add(c.toJsonObject());
		}
		return classesArray.toString();
	}

	@RequestMapping(value = "/appointments", method = RequestMethod.GET)
	String getAppointments() {
		JsonArray appsArray = new JsonArray();
		for (Appointment a : appointmentsRepository.findAll()) {
			appsArray.add(a.toJsonObject());
		}
		return appsArray.toString();
	}
}
