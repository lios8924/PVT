package dsv.pvt2018.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Size(max = 40)
	private String username;
    
	@NotNull
    private String password;

    public User(){}
    
    public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }
    
    public String getPassword(){
    	return password;
    }

    public String toString(){
        return "Username: " + username + " - Password: " + password;
    }

}
