package model;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.JsonObject;

@Entity
@Table(name="myclass")
public class Myclass {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "c_generator")
	@SequenceGenerator(name="c_generator", sequenceName = "cc_seq", allocationSize=1)
	@Column(name="id")
	private int id;	

	@Column(name="class_name")
	private String className;	
	
	@Column(name="day")
	private String day;
	
	@Column(name="instructor_id")
	private int instructorId;
	
	@Column(name="start_time")
//	@Temporal(TemporalType.TIME)
	private Time startTime;
	
	@Column(name="end_time")
//	@Temporal(TemporalType.TIME)
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


