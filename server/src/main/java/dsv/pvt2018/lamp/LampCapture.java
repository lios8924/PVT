package dsv.pvt2018.lamp;


public class LampCapture {

	private String team;
	private int lamp;
	public LampCapture(String team, int lampId) {
		super();
		this.team = team;
		this.lamp = lampId;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getLampId() {
		return lamp;
	}
	public void setLampId(int lampId) {
		this.lamp = lampId;
	}
	
	
	
}
