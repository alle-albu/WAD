package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;

import dao.AppointmentsRepository;
import dao.InstructorsRepository;
import dao.MyclassesRepository;
import pojos.MyAppointment;
import pojos.MyClasses;
import pojos.MyInstructor;
import statuses.AlreadyExistsException;
import statuses.NotFoundException;
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
	
	@RequestMapping(value="/myclasses/{day}", method=RequestMethod.GET)
	String getMyclassesByDay(@PathVariable("day") String day) {
		JsonArray arr = new JsonArray();

        for (Myclass c : myclassesRepository.findAll()) {
        	 System.out.println(c.getDay()+"  "+day+"  "+c.getDay().compareToIgnoreCase(day.toString()));
            if (c.getDay().toString().compareToIgnoreCase(day.toString())>40) {
                arr.add(c.toJsonObject());
            }
        }
        if (arr.size() > 0) {
            return arr.toString();
        } else {
            throw new NotFoundException();
        }
	}
	
	@RequestMapping(value = "/add/instructor", method = RequestMethod.POST)
	void addInstructor(@RequestBody MyInstructor instructor) {
		System.out.println(instructor.toJsonObject().toString());
		Instructor it = new Instructor();
		it.setFirstName(instructor.getFirstName());
		it.setLastName(instructor.getLastName());
		it.setSalary(instructor.getSalary());
		if (instructorsRepository.findByLastName(instructor.getLastName()) != null
				&& instructorsRepository.findByFirstName(instructor.getFirstName()) != null) {
			throw new AlreadyExistsException();
		} else {
			instructorsRepository.save(it);
		}
	}

	@RequestMapping(value = "/delete/instructor/{id}")
	public void deleteInstructor(@PathVariable int id) {
		if (instructorsRepository.exists(id)) {
			Instructor r = instructorsRepository.findOne(id);
			instructorsRepository.delete(r);
		} else {
			throw new NotFoundException();
		}
	}
	
	@RequestMapping(value = "/add/myclass", method = RequestMethod.POST)
	void addMyclass(@RequestBody Myclass c) {
		
		myclassesRepository.save(c);
		
	}
	
	@RequestMapping(value = "/delete/myclass/{id}")
	public void deleteMyclass(@PathVariable int id) {
		if (myclassesRepository.exists(id)) {
			Myclass r = myclassesRepository.findOne(id);
			myclassesRepository.delete(r);
		} else {
			throw new NotFoundException();
		}
	}

	@RequestMapping(value = "/add/appointment", method = RequestMethod.POST)
	void addAppointment(@RequestBody MyAppointment app) {
		Appointment it = new Appointment();
		it.setFirstName(app.getFirstName());
		it.setLastName(app.getLastName());
		it.setClassId(app.getClassId());
	//	if(appointmentsRepository.findByClassId(it.getClassId())!=null && appointmentsRepository.findByFirstName(it.getFirstName())!=null && appointmentsRepository.findByLastName(it.getLastName())!=null) {
	//		throw new AlreadyExistsException();
	//	} else {
			appointmentsRepository.save(it);
	//	}
	}

	@RequestMapping(value = "/delete/appointment/{id}")
	public void deleteAppointment(@PathVariable int id) {
		if (appointmentsRepository.exists(id)) {
			Appointment r = appointmentsRepository.findOne(id);
			appointmentsRepository.delete(r);
		} else {
			throw new NotFoundException();
		}
	}
}
