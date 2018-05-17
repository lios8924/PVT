package dsv.pvt2018.lamp.capture;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import dsv.pvt2018.user.User;

@Entity
@Table(name = "lamp_captures")
public class LampCapture {

	private String team;
	private int lamp;
	
	@OneToMany
	@JoinColumn(name = "username")
	private User user;
	
	private long timeCaptured;
	
	private long endTimeOfCapture;
	
	public LampCapture() {
		super();
	}
	
	public LampCapture(String team, int lampId, User user) {
		super();
		this.team = team;
		this.lamp = lampId;
		this.user = user;
		timeCaptured = System.currentTimeMillis();
		endTimeOfCapture = 0;
	}
	
	public String getTeam() {
		return team;
	}
	
	public int getLamp() {
		return lamp;
	}
	
	public User getTaker(){
		return user;
	}
	
	public void setEndTimeOfCapture(){
		endTimeOfCapture = System.currentTimeMillis();
	}
	
	public int getLampHoldTime(){
		if(endTimeOfCapture == 0)
			return 0; //kasta undantag eller nåt.
		else{
			return (int)(endTimeOfCapture - timeCaptured) / 1000;
		}
	}
	
	public String toString(){
		return "Team: " + team + "  lamp: " + lamp;
	}
	
	
	
}
