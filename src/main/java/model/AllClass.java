package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.JsonObject;

@Entity
@Table(name="allclasses")
public class AllClass {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "c_generator")
	@SequenceGenerator(name="c_generator", sequenceName = "ac_seq", allocationSize=1)
	@Column(name="id")
	private int id;	

	@Column(name="class_name")
	private String className;	
	
	@Column(name="description")
	private String description;
	
	@Column(name="video")
	private String video;
	
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String ii) {
		description=ii;
	}
	
	public String getVideo() {
		return video;
	}
	
	public void setVideo(String d) {
		video=d;
	}
	
	
	public JsonObject toJsonObject() {
		JsonObject it = new JsonObject();
		it.addProperty("id", id);
		it.addProperty("className", className);
		it.addProperty("description", description);
		it.addProperty("video", video);
		return it;
	}
}


