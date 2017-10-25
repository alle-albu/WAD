package pojos;

import java.sql.Time;

import com.google.gson.JsonObject;


public class MyClasses {
	private int id;	

	private String className;	
	
	private String day;
	
	private int instructorId;
	
	private Time startTime;
	
	private Time endTime;
	
	public int getId() {
		return id;
	}
	
	public void setId(int x) {
		id=x;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String cn) {
		className=cn;
	}
	
	public int getInstructorId() {
		return instructorId;
	}
	
	public void setInstructorId(int ii) {
		instructorId=ii;
	}
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String d) {
		day=d;
	}
	
	public Time getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Time st) {
		startTime=st;
	}
	
	public Time getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Time et) {
		endTime=et;
	}
	
	public JsonObject toJsonObject() {
		JsonObject it = new JsonObject();
		it.addProperty("id", id);
		it.addProperty("className", className);
		it.addProperty("day", day);
		it.addProperty("instructorId", instructorId);
		it.addProperty("startTime", startTime.toString());
		it.addProperty("endTime", endTime.toString());
		return it;
	}
}


