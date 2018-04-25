package dsv.pvt2018.login;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LoginService {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "User1", "user1@test.com", "1234567890"),
            new User(1, "User2", "user2@test.com", "abcdefghij"),
            new User(1, "User4", "user3@test.com", "12345abcde")
    ));

    public List<User> getUsers(){
        return users;
    }

    private User findUser(String username){
        for(User u : users){
            if(u.getUsername().equals(username))
                return u;
        }
        return null;
    }

    public User validateUser(String username, String password){
        User user = findUser(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

}