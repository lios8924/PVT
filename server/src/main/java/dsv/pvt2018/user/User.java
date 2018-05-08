package dsv.pvt2018.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Integer id;

	@Id
	private String userName;
    
	@NotNull
    private String password;

    public User(){}
    
    public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }
    
    public String getPassword(){
    	return password;
    }


}
