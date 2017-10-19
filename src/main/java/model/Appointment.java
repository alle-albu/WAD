package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.gson.JsonObject;

@Entity
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "app_generator")
	@SequenceGenerator(name="app_generator", sequenceName = "app_seq", allocationSize=1)
	@Column(name="id")
	private int id;	

	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="class_id")
	private int classId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int x) {
		id=x;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String fn) {
		firstName=fn;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String ln) {
		lastName=ln;
	}
	
	public int getClassId() {
		return classId;
	}
	
	public void setClassId(int x) {
		classId=x;
	}
	
	public JsonObject toJsonObject() {
		JsonObject it = new JsonObject();
		it.addProperty("id", id);
		it.addProperty("first name", firstName);
		it.addProperty("last name", lastName);
		it.addProperty("class id", classId);
		return it;
	}
}
