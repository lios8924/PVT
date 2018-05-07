package dsv.pvt2018.login;

import dsv.pvt2018.user.User;
import dsv.pvt2018.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LoginService {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("User1", "user1@test.com", "1234567890"),
            new User("User2", "user2@test.com", "abcdefghij"),
            new User("User4", "user3@test.com", "12345abcde")
    ));


    public List<User> getUsers(){
        userRepository.saveAll(users); //add testdata
        return userRepository.findAll();
    }

    @Autowired
    private UserRepository userRepository;

    private User findUser(String username){
        for(User u : userRepository.findAll()){
            if(u.getUserName().equals(username))
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