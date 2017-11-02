package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.google.gson.JsonObject;

@CrossOrigin(maxAge = 3600)
@Entity
@Table(name="myinstructor")
public class Myinstructor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8976005777231062563L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ins_generator")
	@SequenceGenerator(name="ins_generator", sequenceName = "mi_seq", allocationSize=1)
	@Column(name="id")
	private int id;	

	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="photo")
	private byte[] photo;
	
	@Column(name="photolnk")
	private String photolnk;
	
	@Column(name="description")
	private String description;
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String getPhotoLnk() {
		return photolnk;
	}
	
	public String getDescription() {
		return description;
	}
	
	public byte[] getPhoto() {
		return photo;
	}
	
	public void setPhoto(byte[] x) {
		photo=x;
	}
	
	public void setPhotoLnk(String x) {
		photolnk=x;
	}
	
	public void setDescription(String x) {
		description=x;
	}
	
	public void setId(int x) {
		id=x;
	}
	
	public void setFirstName(String fn) {
		firstName=fn;
	}
	
	public void setLastName(String ln) {
		lastName=ln;
	}
	
	public void setSalary(double s) {
		salary=s;
	}
	
	public JsonObject toJsonObject() {
		JsonObject it = new JsonObject();
		it.addProperty("id", id);
		it.addProperty("firstName", firstName);
		it.addProperty("lastName", lastName);
		it.addProperty("salary", salary);
		String s=new String(photo);
		it.addProperty("photo", s);
		it.addProperty("photolnk", photolnk);
		it.addProperty("description", description);
		return it;
	}
}
