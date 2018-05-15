package dsv.pvt2018.lamp;


public class LampCapture {

	private String team;
	private int lampId;
	public LampCapture(String team, int lampId) {
		super();
		this.team = team;
		this.lampId = lampId;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getLampId() {
		return lampId;
	}
	public void setLampId(int lampId) {
		this.lampId = lampId;
	}
	
	
	
}
