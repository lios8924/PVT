package dsv.pvt2018.login;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LoginService {

    private List<MockUser> users = new ArrayList<>(Arrays.asList(
            new MockUser("User1", "1234567890"),
            new MockUser("User2", "abcdefghij"),
            new MockUser("User4", "12345abcde")
    ));

    public List<MockUser> getUsers(){
        return users;
    }

    public boolean addUser(MockUser user){
        return users.add(user);
    }

    private MockUser findUser(String username){
        for(MockUser u : users){
            if(u.getUsername().equals(username))
                return u;
        }
        return null;
    }

    public MockUser validateUser(String username, String password){
        MockUser user = findUser(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

}