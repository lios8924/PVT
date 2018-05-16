/*package dsv.pvt2018.login;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mock_users")
public class MockUser {

    //private int id;
    @Id
    @Size(max = 40)
    private String username;
    private String password;

    public MockUser(){}

    public MockUser(String username, String password){
        //this.id = id;
        this.username = username;
        this.password = password;
    }

    /*public int getId() {
        return id;
    }*/
/*
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "Username: " + username + " - Password: " + password;
    }
}
*/