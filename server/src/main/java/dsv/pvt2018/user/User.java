package dsv.pvt2018.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class User {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Integer id;

	//Se till att de inte kan vara null sen.
	//använt userName som ID så länge.
	@Id
	private String userName;

	@NotNull
    private String email;
    
	@NotNull
    private String password;

    public User(){}
    
    public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
    
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }
    
    public String getPassword(){
    	return password;
    }


}
