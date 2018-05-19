package dsv.pvt2018.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dsv.pvt2018.model.Account;
import dsv.pvt2018.model.User;

@Service
public class LoginService {

    @Autowired
    UserService userService;

    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    public boolean addUser(User user) {
        return userService.addUser(user) != null;
    }

    private User findUser(Long id) {
        Optional<User> optional = userService.findUserById(id);
        return optional.orElse(null);
    }

    private User findUser(String username) {
        Optional<User> optional = userService.findUserByUserName(username);
        return optional.orElse(null);
    }

    public User validateUserByName(String username) {
        return findUser(username);
    }

    public User validateUser(String username, String password) {
        User user = findUser(username);
        if(user != null && Account.encryptPassword(password, user.getSalt()).equals(user.getPassword())) {
            return user;
        }
        return null;
    }

}
