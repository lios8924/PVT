package dsv.pvt2018.login;

import dsv.pvt2018.user.User;
import dsv.pvt2018.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    UserService userService;

    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    public boolean addUser(User user){
        return userService.addUser(user) != null;
    }

    private User findUser(String username){
        Optional<User> optional = userService.findUserById(username);
        return optional.orElse(null);
    }

    public User validateUserByName(String username){
        return findUser(username);
    }

    public User validateUser(String username, String password){
        User user = findUser(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

}