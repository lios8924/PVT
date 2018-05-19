package dsv.pvt2018.model;


public class LampCapture {

	private String team;
	private int lamp;

	public LampCapture() {
		super();
	}

	public LampCapture(String team, int lampId) {
		super();
		this.team = team;
		this.lamp = lampId;
	}

	public String getTeam() {
		return team;
	}

	public int getLamp() {
		return lamp;
	}

	public String toString(){
		return "Team: " + team + "  lamp: " + lamp;
	}

}
