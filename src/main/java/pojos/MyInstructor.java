package pojos;


import com.google.gson.JsonObject;


public class MyInstructor  {

	private int id;	

	private String firstName;
	
	private String lastName;
	
	private double salary;
	
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
		return it;
	}
}

