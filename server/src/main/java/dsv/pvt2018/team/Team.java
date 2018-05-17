package dsv.pvt2018.team;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dsv.pvt2018.user.User;

@Entity
@Table(name = "teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany
	@JoinColumn(name = "username")
	private List<User> teamMembers;
	
	@Column(unique = true)
	private String colour;

	public Team() {
		super();
	}
	
	public Team(String colour) {
		super();
		this.colour = colour;
	}

	public Integer getId() {
		return id;
	}

	public List<User> getTeamMembers() {
		return teamMembers;
	}
	
	public void addUser(User user){
		teamMembers.add(user);
	}
	
	public String getColour() {
		return colour;
	}
	
	
	
	
}
