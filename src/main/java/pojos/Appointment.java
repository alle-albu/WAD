package pojos;


import com.google.gson.JsonObject;

public class Appointment {

	private int id;	

	private String firstName;
	
	private String lastName;
	
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
